(function($){
	jQuery.fn.dj_Windows = function(windowObj, param) {
		var $container = $("<div></div>");
		var $titlebar = $("<div></div>");
		var $titletext = $("<span></span>");
		var $appicon = $("<img></img>");
		
		$container.addClass(param.cssclass);
		$container.addClass("window");
		
		$container.css({
			"height" : param.height,
			"width" : param.width			
		});		
		
		$titlebar.addClass("titleBar");
		
		$appicon.attr("src", "resource/images/icon1/png/16x16/app.png");
		$titlebar.append($appicon);		
		
		$titletext.html(param.title);
		$titlebar.append($titletext);		
		
		$container.append($titlebar);
		this.append($container);
		
		mainToolbarObj = windowObj.mtb;
		$container.dj_ToolBar(mainToolbarObj, {
			"":""
		});
		
		tabObj = windowObj.tt; 
		$container.dj_TabBar(tabObj, {
			"":""
		});
	};
})(jQuery);