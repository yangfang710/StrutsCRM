       var loadXML = function (xmlFile) {
            var xmlDoc;
            if (window.ActiveXObject) {
                xmlDoc = new ActiveXObject('Microsoft.XMLDOM');//IE浏览器
                xmlDoc.async = false;
                xmlDoc.load(xmlFile);
            }
            else if (isFirefox=navigator.userAgent.indexOf("Firefox")>0) { //火狐浏览器
            //else if (document.implementation && document.implementation.createDocument) {//这里主要是对谷歌浏览器进行处理
                xmlDoc = document.implementation.createDocument('', '', null);
                xmlDoc.load(xmlFile);
            }
            else{ //谷歌浏览器
              var xmlhttp = new window.XMLHttpRequest();
                xmlhttp.open("GET",xmlFile,false);
                xmlhttp.send(null);
                if(xmlhttp.readyState == 4){
                	xmlDoc = xmlhttp.responseXML.documentElement;
           	 	} 
            }
            return xmlDoc;
        };

        // 首先对xml对象进行判断
      	var checkXMLDocObj = function (xmlFile) {
            var xmlDoc = loadXML(xmlFile);
            if (xmlDoc == null) {
                alert('您的浏览器不支持xml文件读取,于是本页面禁止您的操作,推荐使用IE5.0以上可以解决此问题!');
                window.location.href = '../err.html';
            }
            return xmlDoc;
        };
        window.onload=function(){
			window.xmlDoc = checkXMLDocObj('../js/address.xml');//读取到xml文件中的数据
			var cities = xmlDoc.getElementsByTagName('City');
			//alert(cities.length);
			//得到所有国家节点
			var countries = xmlDoc.getElementsByTagName('CountryRegion');

			//得到国家的下拉列表框
			window.countryNode = document.getElementById("countryNode");
			//得到省份下拉列表框
			window.stateNode = document.getElementById("stateNode");
			//得到市下拉列表框
			window.cityNode = document.getElementById("cityNode");
			//得到区下拉列表框
			window.regionNode = document.getElementById("regionNode");
			//遍历国家节点
			for(var i=0;i<countries.length;i++){
				//创建option选项节点
				var newOption = document.createElement("option");
				//option节点添加文本节点
				var textNode = document.createTextNode(countries[i].getAttribute("Name"));
				newOption.appendChild(textNode);
				countryNode.appendChild(newOption);
			}
			countryNode.onchange = function(){
				var selectedCountryName = this.value;
				var selectedCountryNode = getElementByAttribute(xmlDoc,"CountryRegion","Name",selectedCountryName);
				//得到所有省份
				var states = selectedCountryNode.getElementsByTagName("State");

				//清空列表
				stateNode.options.length = 0;
				stateNode.innerHTML = "<option selected>请选择</option>";
				cityNode.options.length = 0;
				cityNode.innerHTML = "<option selected>请选择</option>";
				regionNode.options.length = 0;
				regionNode.innerHTML = "<option selected>请选择</option>";
				//遍历省份节点
				if(states.length==0){
					stateNode.options.length = 0;
					stateNode.innerHTML = "<option selected>无</option>";
					cityNode.options.length = 0;
					cityNode.innerHTML = "<option selected>无</option>";
					regionNode.options.length = 0;
					regionNode.innerHTML = "<option selected>无</option>";
				}else if(states.length==1 && !states[0].hasAttribute("Name")){
					stateNode.options.length = 0;
					stateNode.innerHTML = "<option selected>无</option>";
					var cities = states[0].getElementsByTagName("City");
					//alert(cities.length);
					if(cities.length==0){
						cityNode.options.length = 0;
						cityNode.innerHTML = "<option selected>无</option>";
						regionNode.options.length = 0;
						regionNode.innerHTML = "<option selected>无</option>";
					}else{
						cityNode.options.length = 0;
						cityNode.innerHTML = "<option selected>请选择</option>";
						regionNode.options.length = 0;
						regionNode.innerHTML = "<option selected>请选择</option>";
						for(var j=0;j<cities.length;j++){
							var newOption = document.createElement("option");
							var textNode = document.createTextNode(cities[j].getAttribute("Name"));
							newOption.appendChild(textNode);
							cityNode.appendChild(newOption);
						}
					}
				}else{
					cityNode.options.length = 0;
					cityNode.innerHTML = "<option selected>请选择</option>";
					regionNode.options.length = 0;
					regionNode.innerHTML = "<option selected>请选择</option>";
					//regionNode.style.display = "none";
					for(var i=0;i<states.length;i++){
						var newOption = document.createElement("option");
						var textNode = document.createTextNode(states[i].getAttribute("Name"));
						newOption.appendChild(textNode);
						stateNode.appendChild(newOption);
					}
				}

			};
			stateNode.onchange = function(){
				var selectedStateName = this.value;
				var selectedStateNode = getElementByAttribute(xmlDoc,"State","Name",selectedStateName);
				var cities = selectedStateNode.getElementsByTagName("City");
				cityNode.options.length = 0;
				cityNode.innerHTML = "<option selected>请选择</option>";
				regionNode.options.length = 0;
				regionNode.innerHTML = "<option selected>请选择</option>";
				if(cities.length==0){
					cityNode.options.length = 0;
					cityNode.innerHTML = "<option selected>无</option>";
					regionNode.options.length = 0;
					regionNode.innerHTML = "<option selected>无</option>";
				}else if(cities.length==1 && !cities[0].hasAttribute("Name")){
					cityNode.options.length = 0;
					cityNode.innerHTML = "<option selected>无</option>";
					var regions = cities[0].getElementsByTagName("Region");
					if(regions==0){
					regionNode.options.length = 0;
					regionNode.innerHTML = "<option selected>无</option>";
					}else{
						regionNode.options.length = 0;
						regionNode.innerHTML = "<option selected>请选择</option>";
						for(var i=0;i<regions.length;i++){
							var newOption = document.createElement("option");
							var textNode = document.createTextNode(retions[i].getAttribute("Name"));
							newOption.appendChild(textNode);
							regionNode.appendChild(newOption);
						}
					}
				}else{
					for(var j=0;j<cities.length;j++){
						if(cities[j].hasAttribute("Name")){
							var newOption = document.createElement("option");
							var textNode = document.createTextNode(cities[j].getAttribute("Name"));
							newOption.appendChild(textNode);
							cityNode.appendChild(newOption);
						}
					}
				}
			};
			cityNode.onchange = function(){
				var selectedCityName = this.value;
				var selectedCityNode = getElementByAttribute(xmlDoc,"City","Name",selectedCityName);
				var regions = selectedCityNode.getElementsByTagName("Region");
				if(regions.length==0){
					regionNode.options.length = 0;
					regionNode.innerHTML = "<option selected>无</option>";
				}else{
					regionNode.options.length = 0;
					regionNode.innerHTML = "<option selected>请选择</option>";
					for(var i=0;i<regions.length;i++){
						var newOption = document.createElement("option");
						var textNode = document.createTextNode(regions[i].getAttribute("Name"));
						newOption.appendChild(textNode);
						regionNode.appendChild(newOption);
					}
				}
			};
        };
        var getElementByAttribute = function(xmlDoc,field,attrname,attrvalue){
            var list = xmlDoc.getElementsByTagName(field);
            for(var i=0;i<list.length;i++){
                if(list[i].getAttribute(attrname)==attrvalue){
                    return list[i];
                }
            }
        };
    function query(){
    	var countryNode = document.getElementById("countryNode").value;
		//得到省份下拉列表框
		var stateNode = document.getElementById("stateNode").value;
		//得到市下拉列表框
		var cityNode = document.getElementById("cityNode").value;
		//得到区下拉列表框
		var regionNode = document.getElementById("regionNode").value;
		
		var address = countryNode+"--"+stateNode+"--"+cityNode+"--"+regionNode;

		document.getElementById("address").value=address;
    }