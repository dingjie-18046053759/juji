//首页九宫格点击效果添加
$('.icon-box ul li').on('touchstart',function(){
	$(this).css('opacity','0.5');
});
$('.icon-box ul li').on('touchend',function(){
	$(this).css('opacity','1');
});

//底部菜单点击效果添加
$('.tab-bottom ul li').on('touchstart',function(){
	$(this).css('opacity','0.5');
});
$('.tab-bottom ul li').on('touchend',function(){
	$(this).css('opacity','1');
});

//轮播参数控制
var swiper = new Swiper('.swiper-container', {
    pagination: '.swiper-pagination',
    nextButton: '.swiper-button-next',
    prevButton: '.swiper-button-prev',
    paginationClickable: true,
    spaceBetween: 30,
    centeredSlides: true,
    autoplay: 5000,
    autoplayDisableOnInteraction: false
});

function openModal(){
    $('.modal').css('display','block');
}
function closeModal(){
    $('.modal').css('display','none');
}