var chartDataStr = decodeHtml(chartData);
var chartJSONArray = JSON.parse(chartDataStr);

var arrayLength = chartJSONArray.length;
var numericData = [];
var labelData = [];

for (var i = 0; i < arrayLength; i++) {
	numericData[i] = chartJSONArray[i].value;
	labelData[i] = chartJSONArray[i].label;
}

// For a Pie Chart
new Chart(document.getElementById("pieChart"), {
	type : 'pie',
	data : {
		labels : labelData,
		datasets : [ {
			label : 'My First dataset',
			backgroundColor : [ "#3e95cd", "#8e5ea2", "#3cba9f" ],
			data : numericData
		} ]
	},
	options : {
		title: {
			display: true,
			text: 'Project Statuses'
		}
	}
});

// "[{"value": 1, "label": "COMPLETED"},{"value": 2, "label":
// "INPROGRESS"},{"value": 1, "label": "NOTSTARTED"}]"
function decodeHtml(html) {
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}