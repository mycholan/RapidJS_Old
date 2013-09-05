var FactoryTabHandler = function() {
	this.CurrentTab = null;
	
	this.InitMainTabBar = function(MainTabObj, TabDiv) {				
		var ulElem = $("<ul></ul>");		
		var liElem = null;
		
		TabDiv.append(ulElem);
		
		for(var i = 0; i < MainTabObj.length; i++) {
			liElem = $('<li metaname="'+MainTabObj[i]+'"><a href="#'+MainTabObj[i]+'">'+MainTabObj[i].substring(3)+'</a></li>');			
			ulElem.append(liElem);
			liElem.click(function(){							
				FactoryObj.GetSubTabMetaData($(this).attr("metaname"));
			});
			TabDiv.append($('<div id="'+MainTabObj[i]+'"></div>'));
		}	
		
		ulElem.append($('<li style="float:right;margin-top: 5px;cursor: pointer;cursor: hand;" onclick="ShowHideTopBar();"><span id="SlideToggle" class="ui-icon ui-icon-triangle-1-n" style="display:inline-block;"></span></li>'));
		TabDiv.tabs();
	};
	
	this.InitSubTabBar = function(SubTabObj) {
		var subTabDiv = $('<div id="subTab" class="tabs-bottom"></div>');
		var ParentDiv = $("#"+this.CurrentTab);
		var ulElem = $("<ul></ul>");		
		var liElem = null;
		
		ParentDiv.html("");
		ParentDiv.append(this.GetTabToolBar());
		ParentDiv.append(subTabDiv);		
				
		for(var i = 0; i < SubTabObj.length; i++) {			
			liElem = $('<li metaname="'+SubTabObj[i]+'" maintab="'+this.CurrentTab+'"><a href="#'+SubTabObj[i]+'">'+SubTabObj[i]+'</a></li>');
			ulElem.append(liElem);
			liElem.click(function(){
				//AlertObj.AlertUser("Sub Tab Item Clicked", $(this).attr("maintab"));
				FactoryObj.GetTabChildMetaData($(this).attr("maintab"));
			});
			if(i == 0) {
				subTabDiv.append($('<div class="tabs-spacer"></div>'));
			}
			subTabDiv.append($('<div id="'+SubTabObj[i]+'">tabs-bottom .ui-tabs-navtabs-bottom .ui-tabs-navtabs-bottom .ui-tabs-navtabs-bottom .ui-tabs-navtabs-bottom .ui-tabs-navtabs-bottom .ui-tabs-navtabs-bottom .ui-tabs-navtabs-bottom .ui-tabs-navtabs-bottom .ui-tabs-navtabs-bottom .ui-tabs-navtabs-bottom .ui-tabs-navtabs-bottom .ui-tabs-navtabs-bottom .ui-tabs-navtabs-bottom .ui-tabs-navtabs-bottom .ui-tabs-navtabs-bottom .ui-tabs-navtabs-bottom .ui-tabs-navtabs-bottom .ui-tabs-navtabs-bottom .ui-tabs-navtabs-bottom .ui-tabs-navtabs-bottom .ui-tabs-navtabs-bottom .ui-tabs-navtabs-bottom .ui-tabs-navtabs-bottom .ui-tabs-navtabs-bottom .ui-tabs-nav</div>'));
		}
		
		subTabDiv.tabs();		
		$( ".tabs-bottom .ui-tabs-nav, .tabs-bottom .ui-tabs-nav > *" ).removeClass( "ui-corner-all ui-corner-top" ).addClass( "ui-corner-bottom" );
		ulElem.appendTo( ".tabs-bottom" );		
		subTabDiv.tabs("refresh");
		subTabDiv.tabs("option", "active", 0);
	};
	
	this.InitSubTabContent = function(ContentObj) {
		
	};
	
	this.GetTabToolBar = function(){
		var Toolbar = $('<div class="fg-toolbar ui-widget-header ui-corner-all ui-helper-clearfix"></div>');
		var Buttonset = $('<div class="fg-buttonset ui-helper-clearfix"></div>');		
		
		Toolbar.append(Buttonset);
		Buttonset.append($('<a href="#" class="fg-button ui-state-default fg-button-icon-solo ui-corner-all"	title="Open"><span class="ui-icon ui-icon-folder-open"></span></a>'));
		Buttonset.append($('<a href="#" class="fg-button ui-state-default fg-button-icon-solo ui-corner-all" 	title="Save"><span class="ui-icon ui-icon-disk"></span></a>'));
		Buttonset.append($('<a href="#" class="fg-button ui-state-default fg-button-icon-solo ui-corner-all" title="Delete"><span class="ui-icon ui-icon-trash"></span></a>'));
		Buttonset.append($('<a href="#" class="fg-button ui-state-default fg-button-icon-solo  ui-corner-all" title="Print"><span class="ui-icon ui-icon-print"></span></a>'));
		Buttonset.append($('<a href="#" class="fg-button ui-state-default fg-button-icon-solo  ui-corner-all" title="Email"><span class="ui-icon ui-icon-mail-closed"></span></a>'));
		
		return Toolbar;
	};
};