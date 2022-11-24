<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>

<script>

$(function(){
$("form").submit(function(event) {
	event.preventDefault();
	//console.log("hi");
	let pnrNo=$("#pnrNo").val();
	
	//console.log("pnrNo : "+pnrNo);
	
	let url='http://localhost:8090/spring-mvc/pnr-status?pnrno='+pnrNo;
	
	$.ajax({
		url:url,
		method:'GET',
		success: function(data) {
			
			let resultDiv=$("#result");
			resultDiv.append($("<p/>").text("Train No "+data.trainNo));
			resultDiv.append($("<p/>").text("Travel Date "+data.travelDate));
			resultDiv.append($("<p/>").html("<hr />"));
			
			for (let passanger of data.passangers) {
				
				let p=$("<p />").html("Passanger Name "+passanger.name+"</br>"
				                + "Gender "+passanger.gender+"</br>"
				                + "Status "+passanger.status+"</br>"
				                + "<hr />");
				resultDiv.append(p);
			}
			
			//alert(JSON.stringify(data));
			/*
			var passangers=data.passangers;
			let text = "";
			for (let passanger of passangers) {
			    text=text+'<tr><td>'+passanger.name+'</td><td>'+passanger.gender+'</td><td>'+passanger.status+'</td></tr>';
			}
			text='<thead><th>Name</th><th>Gender</th><th>Status</th></thead><tbody>'+text+'</tbody>';
			$("#tbdy").html(text);
			*/
			
		}
	})
	
})
})

</script>
</head>
<body>
<form>
Enter PNR No. :<input id="pnrNo"/>
<button type="submit">Check Status</button>
</form>
<table id="tbdy" border="1">
</table>
<div id="result"></div>

</body>
</html>