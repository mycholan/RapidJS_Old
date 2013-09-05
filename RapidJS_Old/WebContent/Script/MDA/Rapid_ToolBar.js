(function($){
	jQuery.fn.dj_ToolBar = function(toolBarObj, param) {
		var icons = new Array("resource/images/icon1/png/16x16/add.png", "resource/images/icon1/png/16x16/save_alt.png", "resource/images/icon1/png/16x16/crossout.png", "resource/images/icon1/png/16x16/inhibit.png", "resource/images/icon1/png/16x16/printer.png", "resource/images/icon2/png/32/db.png", "", "", "", "");
		var $toolbarDiv = $("<div></div>");
		$toolbarDiv.css('border','none');
		var $toolUL = $("<ul></ul>");		
		
		$toolbarDiv.addClass("mainToolBar");
		
		for(var toolbarI = 0; toolbarI < toolBarObj.TTB.length; toolbarI++ ) {
			toolItemObj = toolBarObj.TTB[toolbarI];
			var $toolLI = $("<li></li>");
			$toolItemDiv = $("<div></div>");
			$toolItemDiv.attr("id", toolItemObj.id);
			$toolItemDiv.attr("onclick", toolItemObj.action);
			$toolItemDiv.attr("class", toolItemObj.className);
			$toolItemDiv.addClass("mainToolBarItem");
			$toolItemDiv.css("background-image", "url("+icons[toolbarI]+")");
			if(toolItemObj.src != null && toolItemObj.src != "" && toolItemObj.src != " ") {
				//$toolItemDiv.css("backgroundImage", icons[toolbarI]);
			}
			$toolLI.append($toolItemDiv);
			$toolUL.append($toolLI);
		}
		$toolbarDiv.append($toolUL);
		this.append($toolbarDiv);
	};
})(jQuery);