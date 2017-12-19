appCliente.controller("loginController", function($scope,$http,$location){

	$scope.usuario={};

	$scope.autenticar=function(){
		$http.post("/autenticar", $scope.usuario).then(function(response){
			console.log("sucesso no login-controller" + response.data);
			$location.path("/principal");
		} , function(response){
			console.log("falha " + response);
			$location.path("/");
		});
	 }	
});
