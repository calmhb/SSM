<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="./css/danmuplayer.css">
<script src="./js/jquery-1.11.1.min.js""></script>
<script src="./js/danmuplayer.min.js"></script>

</head>

<body>
	<div id="danmup"></div>
</body>
<script type="text/javascript">
	$(function() {

		$("#danmup").DanmuPlayer({
			src : "move1.mp4", //视频源
			width : 800, //视频宽度
			height : 445, //视频高度
			urlToGetDanmu : "show.do", //用来接收弹幕信息的url  (稍后介绍)
			urlToPostDanmu : "save.do" //用来存储弹幕信息的url  (稍后介绍)
		/*speed : 20000, //弹幕速度，这是数值指的是视频穿过672像素所需要的毫秒数
		//sumTime : 65535, //弹幕视频的总时间，可不填。
		//danmuss : {}, //弹幕列表
		//defaultColor : "#ffffff", //弹幕的默认字体颜色
		fontSizeSmall : 16, //小弹幕的字号
		FontSizeBig : 24, //大弹幕的字号
		opacity : "1", //弹幕默认透明度
		topBottonDanmuTime : 6000, //底部及顶部弹幕存留的时间
		
		maxCountInScreen : 40, //屏幕上的最大的显示弹幕数目,弹幕数量过多时,优先加载最新的。
		maxCountPerSec : 10
		//每分秒秒钟最多的弹幕数目,弹幕数量过多时,优先加载最新的。*/

		});

		
	/* $("#danmup .danmu-div").danmu("addDanmu", [ {
			"text" : "这是滚动弹幕",
			color : "white",
			size : 1,
			position : 0,
			time : 2
		}, {
			"text" : "我是帽子绿",
			color : "green",
			size : 1,
			position : 0,
			time : 3
		}, {
			"text" : "哈哈哈啊哈",
			color : "black",
			size : 1,
			position : 0,
			time : 10
		}, {
			"text" : "这是顶部弹幕",
			color : "yellow",
			size : 1,
			position : 1,
			time : 3
		}, {
			"text" : "这是底部弹幕",
			color : "red",
			size : 1,
			position : 2,
			time : 9
		}, {
			"text" : "大家好，我是伊藤橙",
			color : "orange",
			size : 1,
			position : 1,
			time : 3
		}

		]) */

	});
</script>

</html>
