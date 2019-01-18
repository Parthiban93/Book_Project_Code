


#Http request to get all books data
#BookId auto generated
Request -> http://host:port/Book/getBookList
response json data -> 


[
  
    {
        "bookId": "da7d1f58-0104-4895-b2b0-c02a7ed13e71",
        "bookTitle": "Here Comes Trouble",
        "edition": 1,
        "category": "Biography & Autobiography",
        "isBestSeller": true,
        "description": "Michael Moore catapults readers along a revealing journey through his early life."
    },
    {
        "bookId": "d68e8ecb-a2b6-433e-ad47-b5307fc10782",
        "bookTitle": "Spillover: Animal Infections and the Next Human Pandemic",
        "edition": 1,
        "category": "Science & Nature",
        "isBestSeller": true,
        "description": "Unpredictable. Unforgiving. Untamed.Another inconvenient truth? You don't read an intense, uncompromising Science book like Spillover because you're looking for something to lull you to sleep at night"
    },
     {
        "bookId": "36a92292-3917-4402-829e-ffc023887881",
        "bookTitle": "Eat & Run: My Unlikely Journey to Ultramarathon Greatness",
        "edition": 2,
        "category": "Sports & Recreation ",
        "isBestSeller": false,
        "description": "What an ultramarathon man eats. When it comes to long-distance running, Scott Jurek wrote the book – well, obviously! He was previously profiled in Christopher McDougall's bestselling Sports book, Born to Run, which details Jurek's triumphant experiences as an ultramarathoner."
    },
    {
        "bookId": "f186307b-8579-4ea8-9a74-2d31cd356674",
        "bookTitle": "Acclaimed authors and enduring characters. ",
        "edition": 3,
        "category": "Fiction",
        "isBestSeller": true,
        "description": "An unspeakable crime. A confounding investigation. At a time when the King brand has never been stronger, he has delivered one of his most unsettling and compulsively readable stories."
    },
     {
        "bookId": "a23cdf6c-e244-43be-8daf-b66508a9146a",
        "bookTitle": "A dog and an American dream",
        "edition": 1,
        "category": "Travel",
        "isBestSeller": false,
        "description": "Let's say you're John Steinbeck and it's 1960. You've already entered the ranks of the literary immortals and created classic pieces of Americana back in the '30s with your novels Grapes of Wrath and Of Mice and Men."
    }
   
]





#Http request to create new book
#book id need to be blank 
Request -> http://host:port/Book/addBook
Response -> Success Fully Save!


#Http request to update 
#need to used existing id 
Request -> http://host:port/Book/addBook
json data ->    
{
        "bookId": "a23cdf6c-e244-43be-8daf-b66508a9146a",
        "bookTitle": "A dog and an American dream",
        "edition": 2,
        "category": "Travel",
        "isBestSeller": false,
        "description": "Let's say you're John Steinbeck and it's 1960. You've already entered the ranks of the literary immortals and created classic pieces of Americana back in the '30s with your novels Grapes of Wrath and Of Mice and Men."
    }
Response -> Success Fully Update!
