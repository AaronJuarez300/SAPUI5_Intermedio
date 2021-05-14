define ([], function() {
	console.log('Cargando Suma...');
	
	var Suma = function(num1, num2){
		
		this.suma = num1 + num2;
		
	}
	return Suma;
});