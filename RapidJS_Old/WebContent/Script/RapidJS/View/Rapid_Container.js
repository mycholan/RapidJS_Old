var RapidContainer = function(param){
	this.ContainerParent = null;
	this.LayoutObj = null;
	this.TempObj = null;
	this.Param = param;
	
	this.Members = {
		ID: "",
	    CONTAINER_TITLE : "",
	    DISPLAY : "",
	    ACTIVE : "",
	    LAYOUT : ""
	};
	
	this.SetContainerObject = function(){		
		for(var x in this.Param) {
			this.Members[x] = this.Param[x];
		}
	};
	
	this.InitContainer= function(){		
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
	
	this.StartLayout = function(layoutParent){		
		this.LayoutObj = new RapidLayout({
			LayoutID : this.TempObj.layout.ID,
			LayoutName : this.TempObj.layout.LAYOUT_NAME,
			LayoutType : this.TempObj.layout.LAYOUT_TYPE,			
			LayoutVisible : this.TempObj.layout.DISPLAY,
			LayoutActive :  this.TempObj.layout.ACTIVE,
			ToolbarObject :  this.TempObj.layout.ToolbarObject,
			ViewObject :  this.TempObj.layout.ViewObject
		});		
		
		this.LayoutObj.SetLayoutObject();
		this.LayoutObj.SetLayoutParent(layoutParent);
		this.LayoutObj.InitLayout();
		
		RapidContext.Layout.push(this.LayoutObj);
	};
};