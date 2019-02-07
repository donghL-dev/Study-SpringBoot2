```
{
  "_embedded" : {
    "boards" : [ 
      {
          "title" : "게시글 첫번째",
          "subTitle" : "순서 첫번째",
          "content" : "콘텐츠 첫번쨰 시바아아아아아ㅏ",
          "boardType" : "free",
          "createdDate" : "2019-02-01T18:40:47",
          "updatedDate" : null,
          "_links" : {
              "self" : {
                  "href" : "http://localhost:8081/api/boards/1"
              },
              "board" : {
                  "href" : "http://localhost:8081/api/boards/1"
              },
              "user" : {
                  "href" : "http://localhost:8081/api/boards/1/user"
              }
          }
      },
    ]
  },
  "_links" : {
      "first" : {
          "href" : "http://localhost:8081/api/boards?page=0&size=10"
      },
      "self" : {
          "href" : "http://localhost:8081/api/boards{?page,size,sort}",
          "templated" : true
      },
      "next" : {
          "href" : "http://localhost:8081/api/boards?page=1&size=10"
      },
      "last" : {
          "href" : "http://localhost:8081/api/boards?page=19&size=10"
      },
      "profile" : {
          "href" : "http://localhost:8081/api/profile/boards"
      }
  },
  "page" : {
  "size" : 10,
  "totalElements" : 200,
  "totalPages" : 20,
  "number" : 0
  }
}
```