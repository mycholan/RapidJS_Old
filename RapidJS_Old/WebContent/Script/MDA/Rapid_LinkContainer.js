(function($){
	jQuery.fn.LinkContainer = function(linkObj, param) {
		$container = $("<div></div>");
		$linkUL = $("<ul></ul>");
		$container.addClass("dj_LinkContainer");
		$linkUL.addClass("dj_LinkContainerUL");
		for(var i = 0; i < linkObj.length; i++) {
			$linkUL.append('<li onlick="OpenLink(\''+linkObj[i]+'\')">'+linkObj[i]+'</li>');
		}
		$container.append($linkUL);		
		this.append($container);
	};
});