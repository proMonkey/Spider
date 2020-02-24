$(function () {
    var ini_keyword = getParam("keyword");
    if (ini_keyword !== -1) {
        $(".input-container input").val(ini_keyword);
        var data = "keyword=" + ini_keyword;
        dataHandler(data)
    }

    $(".button-container div").bind("click", function () {
        var input_text = $(".input-container input").val();
        if (input_text.length > 0) {
            var data = "keyword=" + input_text;
            dataHandler(data)

        } else {
            alert("请输入搜索关键字")
        }
    });

})


function getParam(variable) {
    var query = window.location.search.substring(1);
    query = decodeURI(query);

    var vars = query.split("&");
    for (var i = 0; i < vars.length; i++) {
        var pair = vars[i].split("=");
        if (pair[0] == variable) {
            return pair[1];
        }
    }
    return -1;
}

function dataHandler(data) {
    $.ajax({
        type: "POST",
        url: "/searchItems",
        data: data,
        success: function (data) {
            if (data.code == "200") {
                $(".search-result-list").html("");
                console.log(data);
                formatHandler(data.data);
            } else {
                console.log("无结果");
                return -1;
            }
        }
    })
}

function formatHandler(result) {
    for (var i in result) {
        var item_name = result[i].itemName,
            item_id = result[i].itemId,
            item_url = result[i].itemUrl,
            item_img = result[i].itemImg,
            item_price = result[i].itemPrice,
            item_reduction = result[i].itemReduction,
            item_coupon = result[i].itemCoupon,
            item_comment_num = result[i].itemCommentNum,
            item_self_shop = result[i].itemSelfShop,
            item_shop = result[i].itemShop,
            item_origin = result[i].itemOrigin;
        createItemElement(item_id, item_name, item_url, item_img, item_price, item_shop, item_comment_num, item_reduction, item_coupon, item_self_shop, item_origin)
    }
}

function createItemElement(id, name, url, img, price, shop, commentNum, reduction, coupon, selfShop, origin) {
    var logo = '#';
    if(origin === '京东商城'){
        logo = 'assets/京东.png';
    }
    if(origin === '苏宁商城'){
        logo = 'assets/苏宁.png';
    }

    var text = '<li sku=' + id + ' class="search-result-item"><div class="search-result-item-con"><div class="item-img">' +
        '<a href=' + url + ' target="_blank">' +
        '<img src='+ img +' alt="图片"></a></div><div class="item-title"><div class="shop-logo">' +
        '<img src='+ logo +' alt="logo"><span>'+ shop + '(' + selfShop + ')' +'</span>' +
        '</div><div class="title-con"><a href='+ url +' target="_blank">' + name +
        '</a></div></div><div class="item-price">￥<b>'+ price +'</b></div><div class="item-comment">' + commentNum +
        '条评论 </div><div class="discount"><div class="item-reduction">'+ reduction +'</div><div class="item-coupon">'+ coupon +'</div></div></div></li>'

    $(".search-result-list").append(text);
}