'use strict';

angular.module('myApp')

.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/applicants/create', {
        templateUrl: 'applicant/create/view.html',
        controller: 'CreateApplicantCtrl'
    });
}])

.controller('CreateApplicantCtrl', ['$scope', 'Applicant', 'AlertService', 'LookupService', function($scope, Applicant, AlertService, LookupService) {

    $scope.type = 'create'

    $scope.item = new Applicant();
    $scope.save = function() {
        $scope.item.$save(function() {
            AlertService.success();
            $scope.item = new Applicant();
            $scope.form.$setPristine();
        }, function(error) {
            AlertService.error(error.data.message);
        })
    };

    $scope.lookups = LookupService;

}]);