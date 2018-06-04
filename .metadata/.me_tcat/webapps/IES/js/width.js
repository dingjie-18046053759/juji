//rem根值单位随页面宽度变化脚本
var width = document.body.clientWidth;
var fontSize = width/320 * 50;
$('html').css('font-size',fontSize);

//跳出等待弹出页面
function show_modal(){
	$('.modal').addClass('active');
}
