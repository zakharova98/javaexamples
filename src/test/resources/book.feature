Feature: book finding
  Let's find books

  Scenario: Correct non-zero number of books found by author
    Given I have the following books in the store
      | title                     | author                      |
      | Roadside Picnic           | Arkady and Boris Strugatsky |
      | The Lord of the Rings     | J. R. R. Tolkien            |
      | Monday Begins on Saturday | Arkady and Boris Strugatsky |
    When I search for books by author 'Arkady and Boris Strugatsky'
    Then I find 2 books

  Scenario: Correct zero number of books found by author
    Given I have the following books in the store
      | title                     | author                      |
      | Roadside Picnic           | Arkady and Boris Strugatsky |
      | The Lord of the Rings     | J. R. R. Tolkien            |
      | Monday Begins on Saturday | Arkady and Boris Strugatsky |
    When I search for books by author 'Alexander Pushkin'
    Then I find 0 books



