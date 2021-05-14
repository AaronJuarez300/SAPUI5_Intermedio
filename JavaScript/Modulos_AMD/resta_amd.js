define ([], function() {
	console.log('Cargando Resta...');
	
	var Resta = function(num1, num2){
		
		this.resta = num1 - num2;
		
	}
	return Resta;
});