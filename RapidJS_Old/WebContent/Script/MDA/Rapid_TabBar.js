(function($){
	jQuery.fn.dj_TabBar = function(tabObj, param) {
		var $tabbarDiv = $("<div></div>");
		$tabbarDiv.css('border','none');
		var $tabUL = $("<ul actas='tabbar'></ul>");
		$tabUL.addClass("TabUL");
		var $tabContainerWindow = $("<div></div>");
		$tabContainerWindow.attr("id", "tabControlContainer");
		$tabContainerWindow.css({
			"height":"100%",
			"width":"100%"
		});
		var $tabControlsContainer;
		
		for(var tabbarI = 0; tabbarI < tabObj.tti.length; tabbarI++) {
			tabItemObj = tabObj.tti[tabbarI];
			$tabItemLI = $("<li></li>");
			$tabItemLI.addClass('TabStyleNormal');
			if(tabbarI == 0) {
				//$tabItemLI.addClass('TabStyleActive');
			}
			$tabItemLI.addClass(tabItemObj.className);
			$tabItemLI.html(tabItemObj.tabTitle);
			//$tabItemLI.attr("onclick", tabItemObj.action);		
			$tabControlsContainer = $("<div></div>");
			$tabControlsContainer.attr("id", "CC"+tabbarI);
			$tabControlsContainer.css({
				"height":"100%",
				"width":"100%",
				"display":"none"
			});
			
			$tabControlsContainer.ContainerBox(tabItemObj, {"tabIndex":tabbarI});
			$tabContainerWindow.append($tabControlsContainer);
			
			$tabUL.append($tabItemLI);			
		}
		$tabbarDiv.append($tabUL);
		this.append($tabbarDiv);
		this.append($tabContainerWindow);
		
		$('ul[actas="tabbar"] > li').click(function() {
			$('ul[actas="tabbar"] > li').removeClass().addClass("TabStyleNormal");
			$(this).removeClass().addClass("TabStyleActive");
			$('#tabControlContainer > div').css("display","none");
			$("#CC"+$(this).index()).css("display","block");
		});
		
		$('ul[actas="tabbar"] > :first-child').click();
	};
})(jQuery);