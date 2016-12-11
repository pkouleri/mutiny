angular.module('mutiny', ['ngStomp'])
    .controller('PostCtrl', function ($scope, $http, $log, $stomp) {
        $stomp
            .connect('/channel')
            .then(function (frame) {
                var subscription = $stomp.subscribe('/topic/posts', function (payload, headers, res) {
                    console.log("payload is:" + payload);
                    $scope.$apply(function () {
                        $scope.payload = payload;
                    });
                }, {
                    'headers': 'are awesome'
                })
            });

        $http.get('/post/list').then(function (response) {
            $scope.posts = response.data;
        });
    });