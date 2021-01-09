/**
 * �ɼǹ̸����� ��ũ��Ʈ
 * ���� html/js/product_list.js�� ����������3���� ����ϱ� ���� jqueryȭ ��Ŵ.
 * @auther duellist
 * @date 2011-06-16
 **/
var __option_preview_obj = {}; // �ɼ� �̸������ ��������
function mk_prd_option_preview(uid, e) {
    jQuery.ajax({
        type: 'POST',
        url: '/shop/product_data.ajax.html',
        dataType: 'html',
        data: {
            'branduid': uid,
            'type': 'option'
        },
        success: function(req) {
            jQuery('#MK_opt_preview').html(req);
            return false;
        },
        errer: function() {
            alert('�ɼ����� �������� ����');
        }
    });

    var _evt = e.currentTarget ? e.currentTarget : window.event.srcElement;
    var offset = ObjectPosition(_evt);
    __option_preview_obj = _evt;

    jQuery('#MK_opt_preview').css({
        'visibility': 'visible',
        'left': offset[0] + 'px',
        'top': offset[1] + 'px'
    });

    // window resize �̺�Ʈ �߻��� �ɼ� �̸����� ��ġ�� �ٽ� ����
    jQuery(window).resize(function() {
        var _offset = ObjectPosition(__option_preview_obj);
        jQuery('#MK_opt_preview').css({
            'left': _offset[0] + 'px',
            'top': _offset[1] + 'px'
        });
    });
}
function ObjectPosition(obj) {
    var curleft = 0;
    var curtop = 0;
    if (obj.offsetParent) {
        do {
            curleft += obj.offsetLeft;
            curtop += obj.offsetTop;
        } while (obj = obj.offsetParent);
    }

    // ��� ���Ķ����� �߰���
    if (jQuery('#wrap').css('marginLeft') == 'auto') {
        curleft -= jQuery('#wrap').offset().left;
    }

    return [curleft,curtop];
}

function mk_prd_benefit(page_type, uid, target, is_mobile) {
    var url = is_mobile == true ? '/m/product_benefit.html' : '/shop/product_benefit.html';
    jQuery.ajax({
        type: 'GET',
        url: url,
        dataType: 'html',
        data: {
            'uid': uid,
            'page_type': page_type,
            'target': target,
            'rand':Math.random()
        },
        success: function(req) {
            jQuery('#MS_popup_product_benefit_'+page_type).html(req);
            jQuery('#MS_popup_product_benefit_'+page_type).show();
            return false;
        },
        errer: function() {
        }
    });
}

var mk_coupon_down_ing = false;
function mk_prd_benefit_down(page_type, uid, couponnum, is_mobile) {
    var url = is_mobile == true ? '/m/smart_coupon.action.html' : '/shop/smart_coupon.action.html';

    if (mk_coupon_down_ing === true) {
        return false;
    }
    jQuery.ajax({
        type: 'POST',
        dataType: 'json',
        url: url,
        data: {
            'action_type' : 'down_coupon',
            'down_page' : 'BENEFIT',
            'couponnum': couponnum,
            'rand':Math.random()
        },
        success: function(req) {
            if (req.success === true) {
               mk_prd_benefit(page_type, uid, couponnum, is_mobile);
               alert("������ �ٿ� �Ǿ����ϴ�.");
            } else {
                if (req.msg && req.msg.length > 0) {
                    alert(req.msg);
                }
            }
            mk_coupon_down_ing = false;
        }
    });
}
function mk_prd_benefit_login(page_type, uid, is_mobile) {
    var login_url = is_mobile == true ? '/m/login.html' :'/shop/member.html?type=login';
    if (confirm("���� �ٿ��� �α��� �� �����մϴ�.\n�α��� �Ͻðڽ��ϱ�?")) {
        document.location.href = login_url;
    }
}
