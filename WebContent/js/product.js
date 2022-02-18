function munu_detail(product_id){
		document.detailFrm.no.value = product_id;
		document.detailFrm.submit();
	}
	
	
function sort(value){
			if(value=="coffee_asc")
				location.href="index.jsp?contentPage=./../product/coffee_asc.jsp";
			else if(value=="coffee_desc")
				location.href="index.jsp?contentPage=./../product/coffee_desc.jsp";
			else if(value=="dessert_asc")
				location.href="index.jsp?contentPage=./../product/dessert_asc.jsp";
			else if(value=="dessert_desc")
				location.href="index.jsp?contentPage=./../product/dessert_desc.jsp";

		}
