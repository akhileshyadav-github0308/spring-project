angular.module('demo', [])
.controller('Hello', function($scope, $http) {
    $http.get('http://localhost:8090/spring-mvc/response').
        then(function(response) {
            $scope.greeting = response.data;
        });
});