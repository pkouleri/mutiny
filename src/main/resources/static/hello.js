angular.module('mutiny', [])
    .controller('PostCtrl', function ($scope, $http) {
        $http.get('/post/list').then(function (response) {
            $scope.posts = response.data;
            console.log($scope.posts.length);
        });
    });
