var RapidWindows = function(param) {
		/*Parent of window*/
		this.WindowsParentContainer = null;
		this.Param = param;
		this.Window = null;
		/*Parent container for Container Table*/
		this.ContainerContainer = null;
		/*Table object which contains the actual containers*/
		this.ContainerTable = null;
		/*Rapid Container Object*/
		this.RapidContainerObj = null;		
		
		this.Members  = {
				WindowName : "",
				WindowTitle : "",
				WindowID : "",
				WindowType : "",
				WindowWidth : "",
				WindowHeight : "",				
				WindowPosX : "",
				WindowPosY : "",
				WindowIsCenterAlign : "",
				WindowIsTitleVisible : "",
				WindowIsResizable : "",				
				ContainerList : null
		};
		
		this.TypeW = {
				WINDOW :  1,
				DIALOG	: 2,
				CONFIRM : 3,
				ALERT : 4
		};
		
		this.SetWindowObject = function(){
			for(var x in this.Param) {
				this.Members[x] = this.Param[x];
			}
		};
		
		this.SetBaseWindowContainer = function (pContainer){
			this.WindowsParentContainer = pContainer;
		};
		
		this.InitWindow = function(){
			if(this.Members.WindowType == this.TypeW.WINDOW){
				this.CreateWindow_Window();
			}else if(this.Members.WindowType == this.TypeW.DIALOG) {
				this.CreateWIndow_Dialog();
			}else if(this.Members.WindowType == this.TypeW.CONFIRM) {
				this.CreateWIndow_Confirm();
			}else if(this.Members.WindowType == this.TypeW.ALERT) {
				this.CreateWindow_Alert();
			}
		};
		
		this.CreateWindow_Window = function() {
			this.Window = $('<div id="window_'+this.Members.WindowID+'" class="RapidContainer RapidWindow '+this.Members.WindowClass+'"></div>');
			
			var $titlebar = $('<div class="RapidWindowTitleBar"></div>');			
			var $titletext = $("<span></span>");			
			var $appicon = $("<img></img>");			

			this.Window.css({
				"height" : this.Members.WindowHeight,
				"width" : this.Members.WindowWidth			
			});		

			$titlebar.addClass("titleBar");

			$appicon.attr("src", "Resource/images/icon1/png/16x16/app.png");
			$titlebar.append($appicon);		

			$titletext.html(this.Members.WindowTitle);
			$titlebar.append($titletext);		

			this.Window.append($titlebar);			
			this.ContainerContainer = $('<div class="RapidContainer RapidContainerParent"></div>');
			this.Window.append(this.ContainerContainer);
			this.InitContainer();				
			
			this.ShowWindow();
			this.WindowsParentContainer.append(this.Window);			
		};
		
		this.CreateWindow_Dialog = function(){
			
		};
		
		this.CreateWindow_Confirm = function(){
			
		};
		
		this.CreateWindow_Alert = function(){
			
		};
		
		this.InitContainer = function(){
			
			
			
			this.RapidContainerObj = new RapidContainer({
				ContainerType : this.Members.ContainerList.TYPE,
				ContainerCount : this.Members.ContainerList.COUNT,
				Containers : this.Members.ContainerList.CONTAINERS
			});
			
			this.RapidContainerObj.SetContainerObject();
			this.RapidContainerObj.SetContainerParent(this.ContainerContainer);
			this.RapidContainerObj.InitContainer();
		};
		
		this.ShowWindow = function(){
			this.Window.show();
		};
		
		this.HideWindow = function(){
			this.Window.hide();
		};
		
		this.ExitWindow = function(){
			this.Window.remove();
		};
		
		this.ReloadWindow = function(){
			
		};
};

var ContainerManager = function(param) {
	this.Param = param;
	this.ContainerParent = null;	
	this.ContainerTable = null;	
	this.ContainerObj = null;
	this.ContainerObjList = new Array();
	
	this.Members = {
			ContainerType : "",
			ContainerCount : "",			
			Containers : null
	};
	
	this.TypeC = {
			SINGLE : 1,
			HORIZONTAL : 2,
			VERTICAL : 3			
	};
	
	this.SetContainerManagerObject = function(){		
		for(var x in this.Param) {
			this.Members[x] = this.Param[x];
		}
	};
	
	this.SetMasterContainerParent = function(containerParent){
		this.ContainerParent = containerParent;
	};
	
	this.InitContainers = function() {
		this.ContainerTable = $('<table class="RapidTable RapidContainerTable"></table>');
		this.ContainerParent.append(this.ContainerTable);
		
		if(this.Members.ContainerType == this.TypeC.SINGLE) {
			this.ConstructSingleContainer();
		}else if(this.Members.ContainerType == this.TypeC.HORIZONTAL) {
			this.ConstructHorizontalContainer();
		}else if(this.Members.ContainerType == this.TypeC.VERTICAL) {
			this.ConstructVerticalContainer();
		}			
	};	
	
	this.ConstructSingleContainer = function(){
		if(this.Members.Containers[0] == null) {
			return null;
		}
		
		this.ContainerObj = new RapidContainer({
			ID : this.Members.Containers[0].ID,
		    CONTAINER_TITLE : this.Members.Containers[0].CONTAINER_TITLE,
		    DISPLAY : this.Members.Containers[0].DISPLAY,
		    ACTIVE : this.Members.Containers[0].ACTIVE,
		    LAYOUT : this.Members.Containers[0].layout
		});
		
		this.ContainerObj.SetContainerObject();
		this.ContainerObj.InitContainer();
		this.ContainerObjList.push(this.ContainerObj);
		RapidContext.Container.push(this.ContainerObj);
		
		var tableTR = $('<tr></tr>');
		var tableTD = $('<td></td>'); 
		var layoutParent = $('<div id="container_' + this.ContainerObj.Members.ID + '" class="RapidContainer RapidLayoutParent"></div>');
		this.Container.push(layoutParent);
		
		this.ContainerTable.append(tableTR);
		tableTR.append(tableTD);
		tableTD.append(layoutParent);
		
		this.StartLayout(layoutParent);		
	};
	
	this.ConstructHorizontalContainer = function(){
		if(this.Members.Containers[0] == null) {
			return null;
		}
		
		var tableTR = $('<tr></tr>');
		var tableTD = null;
		var layoutParent = null;
		
		this.ContainerTable.append(tableTR);
		for(var i = 0; i < this.Members.ContainerCount; i++) {			
			this.ContainerObj = new RapidContainer({
				ID : this.Members.Containers[i].ID,
			    CONTAINER_TITLE : this.Members.Containers[i].CONTAINER_TITLE,
			    DISPLAY : this.Members.Containers[i].DISPLAY,
			    ACTIVE : this.Members.Containers[i].ACTIVE,
			    LAYOUT : this.Members.Containers[i].layout
			});
			
			this.ContainerObj.SetContainerObject();		
			this.ContainerObj.InitContainer();
			this.ContainerObjList.push(this.ContainerObj);
			RapidContext.Container.push(this.ContainerObj);			
			
			tableTD = $('<td></td>'); 			
			tableTR.append(tableTD);	
			layoutParent = $('<div id="container_' + this.ContainerObj.Members.ID + '" class="RapidContainer RapidLayoutParent"></div>');
			tableTD.append(layoutParent);			
			
			this.ContainerObj.StartLayout(layoutParent);	
		}		
	};
	
	this.ConstructVerticalContainer = function() {
		var tableTR = null, tableTD = null, layoutParent = null;
		for(var i = 0; i < this.Members.ContainerCount; i++) {
			this.ContainerObj = new RapidContainer({
				ID : this.Members.Containers[i].ID,
			    CONTAINER_TITLE : this.Members.Containers[i].CONTAINER_TITLE,
			    DISPLAY : this.Members.Containers[i].DISPLAY,
			    ACTIVE : this.Members.Containers[i].ACTIVE,
			    LAYOUT : this.Members.Containers[i].layout
			});
			
			this.ContainerObj.SetContainerObject();
			this.ContainerObj.InitContainer();
			this.ContainerObjList.push(this.ContainerObj);
			RapidContext.Container.push(this.ContainerObj);
						
			tableTR = $('<tr></tr>');
			tableTD = $('<td></td>'); 
			
			this.ContainerTable.append(tableTR);
			tableTR.append(tableTD);		
			layoutParent = $('<div id="container_' + this.ContainerObj.Members.ID + '" class="RapidContainer RapidLayoutParent"></div>');
			tableTD.append(layoutParent);			
			
			this.ContainerObj.StartLayout(layoutParent);	
		}
	};
};