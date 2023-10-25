var chartDataStr = decodeHtml(chartData);
var chartJsonArray = JSON.parse(chartDataStr);

var arrayLength = chartJsonArray.length;
var numericData = [];
var labelData = [];

for(var i=0; i < arrayLength; i++){
	numericData[i] = chartJsonArray[i].value_;
	labelData[i] = chartJsonArray[i].label;
}

//For a pie chart
new Chart(document.getElementById("myPieChart"), {
	type:'pie',
	// The data for our dataset
	data: {
		labels: labelData,
		datasets: [{
			backgroundColor: ["#3e95cd","#8e5ea2","#3cba9f"],
			data: numericData
		}]
	},
	
	// Configuration options go here
	options: {
	  plugins: {
	    title: {
	      display: true,
	      text: 'Project Statuses'
	    }
	  }
	}
});

//[{"value_": 1, "label": "COMPLETED"},{"value_": 2, "label": "INPROGRESS"},{"value_": 1, "label": "NOTSTARTED"}] String
function decodeHtml(html){
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}