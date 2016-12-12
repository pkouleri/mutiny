var posts = [];
angular.module('mutiny', ['ngStomp'])
    .controller('PostCtrl', function ($scope, $http, $log, $stomp) {
        $stomp
            .connect('http://localhost:8080/channel')
            .then(function (frame) {
                var subscription = $stomp.subscribe('/topic/posts', function (payload, headers, res) {
                    console.log("payload is:" + payload);
                    posts.push(payload);
                    $scope.$apply(function () {
                        $scope.posts = posts;
                    });
                }, {
                    'headers': 'are awesome'
                })
            });

        $http.get('/post/list').then(function (response) {
            posts = response.data;
            $scope.posts = posts;
        });
    });