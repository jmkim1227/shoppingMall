/**
 * ��ǰ�̸����� ��ũ��Ʈ
 * ���� html/js/detailpage.js�� ����������3���� ����ϱ� ���� jqueryȭ ��Ŵ.
 * @auther duellist
 * @date 2011-06-16
 **/

// �𳪹� ��ǰ�̸�����(quick) ��ư ����
window.quick_ele = null;
jQuery('.bt_quick').on('click', function(e) {
    window.quick_ele = this;
}); 

// ��ǰ �̸������ ajax �� utf-8 ���ڵ� �Ǿ --;;
if (typeof get_diy_option_lang == 'undefined') {
    function get_diy_option_lang(type) {
        return ({price_unit: '��'})[type];
    }
}

if (typeof shop_language == 'undefined') {
    var shop_language = 'kor';
}
function viewdetail(brandcode, is_unify_opt, is_cart_free) {
    showdetail('visible', brandcode, is_unify_opt, is_cart_free);
}

var optionJsonData = null;
var stockInfo = null;
// ����ϰ� PC�� ��μ���
var basket_url = MOBILE_USE === '1' ? '/m/basket.html' : '/shop/basket.html';
var shopdetail_url = MOBILE_USE === '1' ? '/m/product.html' : '/shop/shopdetail.html';

function viewlayerbasket(visible, item, type) {
    var _basket = jQuery('#basketpage');
    if (visible == 'visible') {
        jQuery.ajax({
            type: 'POST',
            url: '/shop/gobasket.layer.html',
            dataType: 'html',
            data: {
                'item': item,
                'type': type,
                'device_type': MOBILE_USE
            },
            success: function(req) {
                if (MOBILE_USE === '1') {
                    var _x = (jQuery(document).width() - 310) / 2;
                    var _y = 100;
                    var _w = 300, _h = 152;
                } else {
                    var _x = jQuery(window).width() / 2 + jQuery(document).scrollLeft() - 250;
                    var _y = jQuery(window).height() / 2 + jQuery(document).scrollTop() - 200;
                    var _w = 380, _h = 200;
                }
                // ������ html�� ��üȭ ���Ѽ� �ʿ��� �κи� �̾� �´�.
                // �̷��� ���� ������ ������ html�� style�� ������ ��ü�� ������ ��ģ��.
                if (MOBILE_USE == '1') {
                    var _basket_layer = jQuery('<div></div>').html(req).find('.fixed-btn');
                } else {
                    var _basket_layer = jQuery('<div></div>').html(req).find('table:first');
                }
                jQuery(_basket).html(_basket_layer).css({
                    'width': _w,
                    'height': _h,
                    'left': _x,
                    'top': _y,
                    'zIndex': 10000,
                    'visibility': visible
                }).show();
                return false;
            }
        });
    } else {
        jQuery(_basket).css('visibility', visible);
        showdetail('hidden');
    }
}

var Items = {};
function showdetail(visible, brandcode, is_unify_opt, is_cart_free) {
    Items = {};
    if (visible == 'visible') {
        if (is_unify_opt) {
            loadJs('/js/jquery.diy_option.js');
        }
        var _param = {
            'request': 'ajax',
            'brandcode': brandcode,
            'is_cart_free': (is_cart_free == 'Y' ? is_cart_free : '')
        };

        var multi_image_url = MOBILE_USE === '1' ? '/m/multi_image.html' : '/shop/multi_image.html';
        jQuery.ajax({
            type: 'POST',
            url: multi_image_url,
            dataType: 'json',
            data: _param,
            success: function(req) {
                if (req.uid) {
                    Items = {
                        '0': {
                            'uid': req.uid,
                            'name': "'" + req.brandname + "'",
                            'desc': "'" + req.brandname + "'",
                            'images': req.multi_image
                        }
                    };
                }
            }
        });

        var response = '';
        var detail_url = MOBILE_USE === '1' ? '/m/product_preview.html' : '/shop/detailpage.html';
        var xjson = jQuery.ajax({
            type: 'POST',
            url: detail_url,
            dataType: 'html',
            data: _param,
            success: function(req) {
                var json = xjson.getResponseHeader('X-JSON') ? eval('(' + xjson.getResponseHeader('X-JSON') + ')') : null;
                if (json != null) {
                    optionJsonData = json.optionJsonData;
                    stockInfo = json.stockInfo;
                }

                if (req.match('MSG:') != null) {
                    alert(req.replace('MSG:', ''));
                    return false;
                }

                if (is_unify_opt) {
                    jQuery('#detailpage').html(jQuery(req));
                    // ���������� ���� ä����
                    option_manager.info.ORBAS = jQuery('input[name="ORBAS"]', '#detailpage').val();
                    option_manager.info.min_amount = parseInt(jQuery('input[name="min_amount"]', '#detailpage').val());
                    option_manager.info.max_amount = parseInt(jQuery('input[name="max_amount"]', '#detailpage').val());
                    option_manager.info.min_add_amount = parseInt(jQuery('input[name="min_add_amount"]', '#detailpage').val());
                    option_manager.info.product_uid = jQuery('input[name="product_uid"]', '#detailpage').val();
                    option_manager.info.product_name = jQuery('input[name="product_name"]', '#detailpage').val();
                    option_manager.info.product_price = jQuery('input[name="product_price"]', '#detailpage').val();
                    option_manager.info.option_type = jQuery('input[name="option_type"]', '#detailpage').val();
                    option_manager.info.option_display_type = jQuery('input[name="option_display_type"]', '#detailpage').val();
                    option_manager.info.json = eval('(' + jQuery('input[name="optionJsonData"]', '#detailpage').val() + ')');

                    // option_type == 'NO' �� ��� �⺻ �ɼ� ���� �߰���
                    if (option_manager.info.option_type == 'NO' || (jQuery.inArray(option_manager.info.json, Array(undefined, null)) === -1 && object_count(option_manager.info.json.basic) == 1 && option_manager.info.json.basic[0][0].opt_value === undefined)) {
                        option_manager.data = {basic : [[{
                            opt_id: option_manager.info.json.basic[0][0].opt_ids || '0',
                            opt_value: option_manager.info.product_name,
                            opt_stock: option_manager.get_min_amount('basic'),
                            opt_price: 0,
                            sto_id: option_manager.info.json.basic[0][0].sto_id || '0'
                        }]]};
                        option_manager.info.json.basic[0][0].opt_value = option_manager.info.product_name;
                    }
                } else {
                    jQuery('#detailpage').html(req);
                    loadJs('/js/neodesign/option_validate.js', function() { changeOptvalue(); });   // dom �� HTML �� �ѷ��ְ�. changeOptvalue();
                    if (MOBILE_USE === '1') {
                        loadJs('/js/multi_image_mobile.js');
                    } else {
                        loadJs('/js/multi_image.js');
                    }
                    
                    if (req.match('<!-- MULTI_IMAGE -->') != null) {
                        setTimeout(function() {
                            jQuery('#detailpage').html(req);
                            jQuery.imageShow();
                        }, 250);
                    }
                }

                var iebody = (document.compatMode && document.compatMode != 'BackCompat') ? document.documentElement : document.body,
                    _top = navigator.userAgent.match(/MSIE/i) ? iebody.scrollTop : pageYOffset;

                var _left = parseInt(jQuery('#detailpage').outerWidth() / 2) * -1;
                if (MOBILE_USE === '1') {
                    var _top = parseInt(jQuery(document).scrollTop()) + 100;
                    var el = jQuery('#detailpage').css({
                        'display': 'block',
                        'left': '50%',
                        'top': _top + 'px',
                        'zIndex': '9999',
                        'marginLeft': _left + 'px'
                    });
                } else {
                    var _top = (parseInt(jQuery('#detailpage').outerHeight() / 2) + parseInt(_top) * (-1)) * (-1);
                    var el = jQuery('#detailpage').css({
                        'visibility': visible,
                        'left': '50%',
                        'top': '50%',
                        'zIndex': '9999',
                        'marginLeft': _left + 'px',
                        'marginTop': _top + 'px'
                    });
                }
                if (window.quick_ele != null) {     // �𳪹� ������ ���ӽÿ� ������ �־, Ŭ�� element ��ġ�� ó��
                    el.css({'marginTop' : 0 + 'px', 'top' : jQuery(window.quick_ele).offset().top});
                }

                // �ɼ� �� ����
                if (is_unify_opt) {
                    option_value_replace();
                }
            }
        });
    } else {
        if (MOBILE_USE === '1') {
            jQuery('#detailpage').css('display', 'none');
        } else {
            jQuery('#detailpage').css('visibility', visible);
        }
    }
}

function imageview(temp, type) {
    var url;
    var n4;
    var imgsc;

    var windowprops = 'height=350,width=450,toolbar=no,menubar=no,resizable=no,status=no';
    if (type == '1') {
        windowprops += ',scrollbars=yes';
        imgsc = 'yes';
    } else {
        imgsc = '';
    }

    if (temp.length == 0) {
        alert(((shop_language == 'eng') ? "large image is not" : "ū�̹����� �����ϴ�."));
        return;
    }

    n4 = (document.layers) ? true : false;
    if (n4) {
        url = '/shop/image_view.html?scroll=' + imgsc + '&image=/shopimages/' + db + '/' + escape(temp);
    } else {
        url = '/shop/image_view.html?scroll=' + imgsc + '&image=/shopimages/' + db + '/' + temp;
    }
    window.open(url, 'win', windowprops);
}

function send_wish(temp, temp2, opt_type, is_unify_opt) {
    if (is_unify_opt) {
        if (opt_type == 'DIY') {
            if (create_diy_option_input('detailform') === false) {
                return;
            }
        }
        if (create_option_input('detailform', '', 'wish') === false) {
            return;
        }
    } else {
        if (document.getElementById('option_type')) {
            var mobile_use = MOBILE_USE === '1' ? 'Y' : '';
            wishvalidateSubmit(temp, document.detailform, baskethidden, mobile_use);
            return;
        }

        if (temp2 != '') {
            document.detailform.opts.value = '';
            for (var i = 0; i < temp2; i++) {
                document.detailform.opts.value += document.detailform.mulopt[i].selectedIndex + ',';
                document.detailform.optslist.value += document.detailform.mulopt[i].value + '[||]';
            }
        }
        if (typeof document.detailform.spcode != 'undefined' && document.detailform.spcode.selectedIndex < 2) {
            temp2 = document.detailform.spcode.selectedIndex - 1;
            if (typeof document.detailform.spcode2 == 'undefined' || document.detailform.spcode2.type == 'hidden') {
                temp3 = 1;
            } else {
                temp3 = document.detailform.spcode2.selectedIndex - 1;
            }
            /*
            if (num.length > 0 && num[(temp3 - 1) * 10 + (temp2 - 1)] == 0) {
                alert('�����Ͻ� ��ǰ�� �ɼ��� ǰ���Ǿ����ϴ�. �ٸ� �ɼ��� �����ϼ���');
                document.detailform.spcode.focus();
                return;
            }
            */
        }
        if (opt_type == 'NL' || opt_type == 'NU') {
            document.detailform.optslist.value = '';
            if (document.detailform.spcode.selectedIndex > 1) {
                document.detailform.optslist.value = document.detailform.spcode.options[document.detailform.spcode.selectedIndex].text + '[||]';
            }
            if (typeof document.detailform.spcode2 != 'undefined' && document.detailform.spcode2.selectedIndex > 1) {
                if (document.detailform.spcode2.type != 'hidden') document.detailform.optslist.value += document.detailform.spcode2.options[document.detailform.spcode2.selectedIndex].text + '[||]';
            }
        }
    }

    if (typeof baskethidden != 'undefined' && baskethidden == 'Y') {
        document.detailform.ordertype.value += '|parent.';
        document.detailform.target = 'loginiframe';
    } else if (typeof baskethidden != 'undefined' && baskethidden == 'A') {
        document.detailform.ordertype.value += '|parent.|layer';
        document.detailform.target = 'loginiframe';
    }

    document.detailform.action = shopdetail_url;
    document.detailform.mode.value = 'wish';
    document.detailform.optiontype.value = opt_type;
    //document.detailform.target = 'new';	
    document.detailform.submit();
}

function send(temp, temp2, is_unify_opt, is_diy_opt, extra_require, uid) {
    if (extra_require == 'Y') {
        alert('������������ �߰� ���� ��ǰ�� ���� �������ּž� �մϴ�.');
        location.href = shopdetail_url + '?branduid=' + uid;
        return;
    }
    if(temp=="baro") {
       document.detailform.ordertype.value='baro';
       document.detailform.ordertype.value+= "|parent.|layer";
       document.detailform.target = "loginiframe";
    }else {
       document.detailform.ordertype.value='';
       document.detailform.target = "";
    }

    if (is_unify_opt) {
        if (is_diy_opt) {
            if (create_diy_option_input('detailform') === false) {
                return;
            }
        }
        if (create_option_input('detailform') === false) {
            return;
        }
    } else {
        // �Ŀ��ɼ��� ��쿡 validate�� �Ʒ� �Լ��� ��������
        if (document.getElementById('option_type')) {
            document.detailform.action=basket_url;
            validateSubmit(temp, document.detailform, baskethidden);
            return;
        }

        if (document.detailform.amount.value.length == 0) {
            alert(((shop_language == 'eng') ? "Input quantity." : "�ֹ������� �Է��ϼ���."));
            document.detailform.amount.focus();
            return;
        }
        if (isNaN(document.detailform.amount.value)) {
            alert(((shop_language == 'eng') ? "Input numbers in quantity field." : "�ֹ������� ���ڸ� �Է����ּ���."));
            document.detailform.amount.focus();
            return;
        }
        if (temp2 != '') {
            document.detailform.opts.value = '';
            for (var i = 0; i < temp2; i++) {
                if (typeof document.detailform.optselect != 'undefined') {
                    if (document.detailform.optselect[i].value == 1 && document.detailform.mulopt[i].selectedIndex == 0) {
                        alert(((shop_language == 'eng') ? 'Select the options required, must be select option.' : '�ʼ����� �׸��Դϴ�. �ɼ��� �ݵ�� �����ϼ���'));
                        document.detailform.mulopt[i].focus();
                        return;
                    }
                    document.detailform.opts.value += document.detailform.mulopt[i].selectedIndex + ',';
                }
            }
        }
        if (typeof document.detailform.spcode != 'undefined' && document.detailform.spcode.selectedIndex < 2) {
            alert(((shop_language == 'eng') ? 'selected option required to buy.' : '�ɼ��� �����ϼž� ���Ű� �����մϴ�.'));
            document.detailform.spcode.focus();
            return;
        }
        if (typeof document.detailform.spcode2 != 'undefined' && document.detailform.spcode2.selectedIndex < 2) {
            alert(((shop_language == 'eng') ? 'selected option required to buy.' : '�ɼ��� �����ϼž� ���Ű� �����մϴ�.'));
            document.detailform.spcode2.focus();
            return;
        }
        if (typeof document.detailform.spcode != 'undefined' && document.detailform.spcode.selectedIndex < 2) {
            temp2 = document.detailform.spcode.selectedIndex - 1;
            if (typeof document.detailform.spcode2 == 'undefined') {
                temp3 = 1;
            } else {
                temp3 = document.detailform.spcode2.selectedIndex - 1;
            }
            if (num[(temp3 - 1) * 10 + (temp2 - 1)] == 0) {
                alert(((shop_language == 'eng') ? 'The item of the selected option is out of stock. Please select another option.' : '�����Ͻ� ��ǰ�� �ɼ��� ǰ���Ǿ����ϴ�. �ٸ� �ɼ��� �����ϼ���'));
                document.detailform.spcode.focus();
                return;
            }
        }
    }
    if (typeof baskethidden != 'undefined' && baskethidden == 'Y') {
        document.detailform.ordertype.value += '|parent.';
        document.detailform.target = 'loginiframe';
    } else if (typeof baskethidden != 'undefined' && baskethidden == 'A') {
        document.detailform.ordertype.value += '|parent.|layer';
        document.detailform.target = 'loginiframe';
    }

    // ��ٱ��� ������ �ϰ�쿡�� ������ ���ε� �Ķ���͸� �߰����ش�.
    if (window.location.pathname == basket_url) {
        document.detailform.reload.value = 'Y';
    }

    document.detailform.action=basket_url;
    document.detailform.submit();
}

function package_send(uid) {
    if (confirm(((shop_language == 'eng') ? 'Please select an option from the product detail page, and put in the basket.\n\nDo you want to go to the product detail page?' : '������������ �ɼ��� �����ϰ� ��ٱ��Ͽ� ����ֽñ� �ٶ��ϴ�.\n\n��ǰ �� �������� �̵��Ͻðڽ��ϱ�?'))) {
        location.href = shopdetail_url + '?branduid='+uid;
    } else {
        return;
    }
}

function count_change(cnt) {
    var amount = document.detailform.amount.value;
    if (cnt == 0) {
        amount++;
    } else if (cnt == 1) {
        if (amount > 1) amount--;
    }
    document.detailform.amount.value = amount;
}

function login_chk(brandcode) {
    alert (((shop_language == 'eng') ? "The service is available only for members. Please login." : "ȸ�����Ը� ������ �Ǵ� �����Դϴ�.\n�켱 �α����� �Ͽ� �ֽñ� �ٶ��ϴ�."));
    location.href = '/shop/member.html?type=wish&brandcode=' + brandcode;
}

function warehousing_call(branduid) {
    win = window.open('/shop/soldout_sms_pop.html?branduid=' + branduid, 'soldout_sms', 'width=450,height=330');
    win.focus();
}

function MS_CyScrap(shopurl, branduid, key, sid) {
    var xml_url = escape('http://' + shopurl + '/cy_scrap.html?branduid=' + branduid + '&key=' + key);
    var cyScrap_url = 'http://api.cyworld.com/openscrap/shopping/v1/?xu=' + xml_url + '&sid=' + sid;
    window.open(cyScrap_url, 'cyopenscrap', 'width=450,height=410');
}

/**
 * onload �̺�Ʈ �ݹ� �Լ� �߰�
 * onload callback test pass : ie6 / ie7 / ie8 / ie9 / ff4 / chrom10
 */
function loadJs(filename, js_function) {
    if (document.getElementById(filename) == null) {
        var fileref = document.createElement('script');
        fileref.setAttribute('type','text/javascript');
        fileref.setAttribute('src', filename);
        fileref.setAttribute('id', filename);

        if (typeof(js_function) == 'function') {
            if (fileref.addEventListener == undefined) {
                fileref.onreadystatechange = function() {
                    if (fileref.readyState == 'loaded') js_function();
                }
            } else {
                fileref.addEventListener('load', js_function, false);
            }
        }

        if (typeof fileref != 'undefined') {
            rtn = document.getElementsByTagName('head')[0].appendChild(fileref);
        }
    } else {
        if (typeof(js_function) == 'function') {
            js_function();
        }
    }
};

var changeOpt2value = function(num) {
    var optionIndex = optval = '';
    var optcnt = 0;
    var oki = oki2 = '-1';
    var soldout_txt = (shop_language == 'eng') ? ' (Out-of-stock)' : ' (ǰ��)';
    if (typeof document.detailform.spcode != 'undefined' && document.detailform.spcode.selectedIndex > 1) {
        temp2 = document.detailform.spcode.selectedIndex - 1;
        if (typeof document.detailform.spcode2 == 'undefined' || document.detailform.spcode2.type == 'hidden') {
            temp3 = 1;
        } else {
            temp3 = document.detailform.spcode2.length;
        }
        for(var i = 2; i < temp3; i++) {
            var len = document.detailform.spcode2.options[i].text.length;
            document.detailform.spcode2.options[i].text = document.detailform.spcode2.options[i].text.replace(soldout_txt, '');
            if (num[(i - 2) * 10 + (temp2 - 1)] == 0) {
                document.detailform.spcode2.options[i].text = document.detailform.spcode2.options[i].text + soldout_txt;
            }
        }
    }
};
