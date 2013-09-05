var ContainerBox = function(tabItemObj, param) {
		this.Container = null;
		
		this.Member = {
				ContainerName : "",
				ContainerTitle : "",
				ContainerID : "",
				ContainerType : "",
				Container_Width : "",
				Container_Height : "",
				Container_Class : "",				
				ContainerIsResisable : "",				
				Layout : null	
		};
		
		this.SetContainerObject = function(param){
			for(var x in param) {
				this.Members[x] = param[x];
			}
		};
		
		this.CreateContainer = function() {
			
		};
		
		var $container, $colLI;
		var $titlespan = $("<span></span>");
		var $rowUL = $("<ul></ul>");
		$rowUL.css("width", "100%");
		
		for(var cContainer = 0; cContainer < tabItemObj.tc.length; cContainer++) {			
			$container = $("<div></div>");	
			$container.css({"border":"solid 1px #a7a7a7", "padding":"10px", "margin-bottom":"10px", "margin-top":"10px"});
			for(var controlI = 0; controlI < tabItemObj.tc[cContainer].testC.length; controlI++) {
				controlObj = tabItemObj.tc[cContainer].testC[controlI];
				if(!controlObj.sameLine) {
					$container.append($rowUL);
					$container.append($("<br/>"));
					$rowUL = $("<ul></ul>");
					$rowUL.css("width", "100%");
				}
				$colLI = $("<li></li>");	
				$colLI.css({"float" : "left", "list-style" : "none"});
				$colLI.html(controlObj.label+"&nbsp;");
				$colLI.append(controlsFactory(controlObj));
				$rowUL.append($colLI);
			}
			this.append($container);
		}
	};
	
	jQuery.fn.controlsFactory = function (controlObj) {
		var $cObj = null;
		if(controlObj != null) {
			if(controlObj.cType == "text") {
				$cObj = $("<input>");
				$cObj.attr("type", "text");
				$cObj.attr("id", controlObj.id );
				$cObj.attr("classname", controlObj.className);
				$cObj.attr("onclick", controlObj.action);
			}else if(controlObj.cType == "button") {
				$cObj =  $("<input>");
				$cObj.attr("type", "button");
				$cObj.attr("id", controlObj.id );
				$cObj.attr("classname", controlObj.className);
				$cObj.attr("onclick", controlObj.action);
			}else if(controlObj.cType == "check") {
				$cObj =  $("<input>");
				$cObj.attr("type", "checkbox");
				$cObj.attr("id", controlObj.id );
				$cObj.attr("classname", controlObj.className);
				$cObj.attr("onclick", controlObj.action);
			}else if(controlObj.cType == "password") {
				$cObj =  $("<input>");
				$cObj.attr("type", "password");
				$cObj.attr("id", controlObj.id );
				$cObj.attr("classname", controlObj.className);
				$cObj.attr("onclick", controlObj.action);				
			}
		}else {
			return $("<span>un-supported</span>");
		}
		if($cObj == null) {
			return $("<span>un-supported</span>");
		}
		return $cObj;
	};
})(jQuery);