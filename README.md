# QuizApp Backend Documentation

## Quiz Class

The `Quiz` class represents a quiz question in the Quiz App. It is annotated with `@Data` from the Lombok library, which automatically generates getters, setters, and other common methods. The class is also annotated with `@Document` from Spring Data MongoDB, indicating that instances of this class will be stored as documents in a MongoDB collection called "questions".

The `Quiz` class has the following fields:
- `id` (String): Represents the unique identifier of the quiz question.
- `question` (String): Holds the actual question text.
- `options` (String[]): An array of strings representing the available answer options for the question.
- `correctOption` (int): Represents the index of the correct answer option within the `options` array.
- `technology` (String): Indicates the technology related to the quiz question.

## Quiz Service Class

The `QuizService` class is an important part of our Quiz App. It's like the brain behind handling quizzes and making everything work smoothly. It's marked with the `@Service` annotation, which tells Spring that it's a special service component.

In our `QuizService`, we depend on the `QuizRepository` interface. This interface helps us communicate with the database and perform various operations on quizzes. We use constructor injection with the `@Autowired` annotation to make sure we have an instance of `QuizRepository` available.

Now, let's talk about what our `QuizService` can do for us:

1. `saveQuiz(Quiz quiz)`: This cool method lets us save a brand new quiz. We simply pass a `Quiz` object to it, and it takes care of storing it in the database. It's pretty awesome, right?

2. `getAllQuizzes()`: This method is super handy when we want to fetch all the quizzes from the database. It gives us a list of all the quizzes that are available for us to play with.

3. `updateQuizById(String id, Quiz quiz)`: Imagine we want to update an existing quiz. No worries! This method comes to the rescue. We provide the `id` of the quiz we want to update along with the new quiz details. It finds the old quiz using the `id`, makes the necessary updates, and saves the changes. How convenient is that?

4. `deleteQuizById(String id)`: Oops! Made a mistake and want to remove a quiz? This method does exactly that. We just need to give it the `id` of the quiz we want to delete, and it takes care of removing it from the database. Simple and effective.

5. `getQuizById(String id)`: When we need to retrieve a specific quiz, this method saves the day. We provide the `id` of the quiz we want, and it fetches the quiz for us. If the quiz exists, we get it back. Otherwise, it kindly returns `null`.

So, you see, our `QuizService` acts as the middleman between our app's controller and the database. It handles the logic for creating, retrieving, updating, and deleting quizzes. With the help of this service, our Quiz App becomes a lot more powerful and fun to use.

## Quiz Controller Class

The `QuizController` class! This class is the controller that handles all the quiz-related requests in our Quiz App. It's marked with the `@RestController` annotation, which tells Spring that it's responsible for handling HTTP requests and generating responses.

We also have the `@CrossOrigin` annotation, which allows cross-origin resource sharing. It's like a friendly gesture that enables our Quiz App to be accessed by different domains.

Now, let's explore the cool features of our `QuizController`:

1. `getAllQuizzes()`: This method is an HTTP GET endpoint that returns a list of all the quizzes available. When we hit the `/quizzes/all` URL, it calls the `getAllQuizzes()` method from the `QuizService`, and voila, we get all the quizzes neatly packaged in the response.

2. `createQuiz(Quiz quiz)`: This is where the magic happens! We use an HTTP POST request to create a new quiz. The quiz details are provided in the request body, and the method calls `saveQuiz(quiz)` from the `QuizService` to save it in the database. Pretty straightforward, right?

3. `getQuizById(String id)`: Need a specific quiz? No worries! Just hit the `/quizzes/{id}` URL, where `{id}` is the unique identifier of the quiz. This method fetches the quiz with the corresponding `id` by calling `getQuizById(id)` from the `QuizService`. We get the quiz we wanted as the response. Awesome!

4. `updateQuizById(String id, Quiz quiz)`: Made a mistake in a quiz? Don't sweat it! This method handles the task of updating a quiz. We hit the `/quizzes/update/{id}` URL, provide the `id` of the quiz we want to update, along with the new quiz details in the request body. The method then calls `updateQuizById(id, quiz)` from the `QuizService`, which takes care of updating the quiz in the database. If the update is successful, we get the "Update Success" message. Otherwise, we receive the "Quiz not found" message.

5. `deleteQuizById(String id)`: Say goodbye to unwanted quizzes! When we hit the `/quizzes/delete/{id}` URL, this method jumps into action. It calls `deleteQuizById(id)` from the `QuizService`, which removes the quiz with the corresponding `id` from the database. If the deletion is successful, we receive the "Delete Success" message. If the quiz is not found, we get the "Quiz not found" message.

## Quiz Repository Class

We have the `@Repository` annotation, which indicates that this class is a repository component in our Spring application. It plays a vital role in data access and provides an abstraction layer for interacting with the database.

`QuizRepository` extends the `MongoRepository` interface, which is a generic interface provided by Spring Data MongoDB. It provides basic CRUD (Create, Read, Update, Delete) operations for the `Quiz` entity, as well as other useful methods.

Here are the methods available in our `QuizRepository`:

1. `findQuizById(String id)`: This method is a custom query method that retrieves a quiz based on its unique `id`. It returns the `Quiz` object that matches the provided `id`.

Apart from this custom method, we also have access to other methods inherited from `MongoRepository`, such as `findById(String id)`. These methods allow us to perform common database operations without writing complex queries.

## MongoDB and Spring
In my Quiz App project, I utilized MongoDB as the database management system, seamlessly integrated with Spring. MongoDB, being a popular NoSQL database, offered the flexibility, scalability, and fast performance that perfectly suited the requirements of my application.


