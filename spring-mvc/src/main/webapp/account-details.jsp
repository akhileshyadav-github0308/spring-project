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
	let pnrNo=$("#accNo").val();
	
	//console.log("pnrNo : "+pnrNo);
	
	let url='http://localhost:8090/spring-mvc/getaccdetails?accno='+pnrNo;
	
	$.ajax({
		url:url,
		method:'GET',
		success: function(data) {
			
			let resultDiv=$("#result");
			resultDiv.children().remove();
			resultDiv.append($("<p/>").text("Acc No. "+data.accNo));
			resultDiv.append($("<p/>").text("Name "+data.name));
			resultDiv.append($("<p/>").text("Type "+data.type));
			resultDiv.append($("<p/>").text("Balance "+data.balance));
			resultDiv.append($("<p/>").html("<hr />"));
			
			for (let transaction of data.transactions) {
				
				let p=$("<p />").html("Txn No. "+transaction.txnNo+"</br>"
				                + "Date & Time "+transaction.dateAndTime+"</br>"
				                + "Type "+transaction.type+"</br>"
				                + "Amoount "+transaction.amoount+"</br>"
				                + "<hr />");
				resultDiv.append(p);
			}
		}
	})
	
})
})

</script>
</head>
<body>
<form>
Enter Acc No. :<input id="accNo"/>
<button type="submit">Get Details</button>
</form>
<table id="tbdy" border="1">
</table>
<div id="result"></div>

</body>
</html>