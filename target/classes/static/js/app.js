var appCliente = angular.module("appCliente", ['ngRoute','ngStomp']);

appCliente.config(function($routeProvider){
	
	$routeProvider
	.when("/login",{templateUrl:'views/login.html',controller:'loginController'})
	.when("/cadastro",{templateUrl:'views/cadastro.html',controller:'usuarioController'})
	.when("/principal",{templateUrl:'views/principal.html',controller:'principalController'})
	.otherwise({redirectTo:'/login'});
});