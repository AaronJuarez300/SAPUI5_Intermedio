define ([], function() {
	console.log('Cargando Division...');
	
	var Division = function(num1, num2){
		
		this.division = num1 / num2;
		
	}
	return Division;
});