function dooperate(op,hrefURL,curPage,sumPage,keyW){
			
			var currentPage = parseInt(curPage);//得到当前页
			var totalPage = sumPage;//最后一页
			if(op=="go"){//输入指定页
				var pageGo = $("#gopage").val();//得到用户输入的字符
				regex=/^\d+$/;
				 if(!regex.test(pageGo)){
					 alert("请填入数字!");
					 $("#gopage").val("");
					 $("#gopage").focus();
					 return;
				 }
				 currentPage = parseInt(pageGo);//当前页为输入的东西
				 
				 if(currentPage<1){//当前页小于1则为1
					 currentPage=1;
				 }
				 if(currentPage>totalPage){//当前页大于最后页则为最后页
					 currentPage=totalPage;
				 }  
			}
			
			if(op=="first"){//首页
				currentPage = 1;
			}
			
			if(op=="next"){//下一页
				currentPage = currentPage+1;
				if(currentPage>=totalPage)
					currentPage = totalPage;
			}
			
			if(op=="pre"){//上一页
				currentPage = curPage-1;
				if(currentPage<=1)
					currentPage = 1;
			}
			
			if(op=="last"){//最后一页	
				currentPage = totalPage;
			}
			location.href=hrefURL+"?currentPage="+currentPage+"&keyWord="+keyW;
			
		}