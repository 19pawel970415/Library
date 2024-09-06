# Library

## Description
Your task is to create a simple rental management system for a library. This system should allow:
- Storing information about various resources (books, board games, newspapers).
- Managing users and their rentals.

## Requirements

### Repositories
1. **RentalRepo** – Repository for storing a list of rentals (`List<Rental>`).
2. **ResourceRepo** – Repository for storing resources such as books, board games, and newspapers (`List<Resource>`).
3. **UserRepo** – Repository for storing users (`List<User>`).

### Resources
1. **Resource** – Abstract class with fields `name` and `id`.
2. **Book** – Class inheriting from `Resource`, with additional fields: `author`, `publicationYear`, and `genre`.
3. **BoardGame** – Class inheriting from `Resource`, with an additional field: `numberOfPlayers`.
4. **Newspaper** – Class inheriting from `Resource`, with an additional field: `edition`.

### Users
1. **User** – Class with fields: `name`, `surname`, `email`, `login`, `password`, and `rentals` (list of rentals).
   - Implement a method to generate a `login` and `password` for new users.

### Rentals
1. **Rental** – Class connecting a user (`User`) with a resource (`Resource`).

### Data Generators
1. **ResourcesGenerator** – Class generating sample resources (books, board games, newspapers) and adding them to the `ResourceRepo`.
2. **UserGenerator** – Class generating sample users and their rentals, then adding them to the `UserRepo` and `RentalRepo`.

### Implementation
1. **Use Lombok** for automatic generation of getters, setters, and constructors.
2. **Use Serializable** to mark classes as serializable to enable saving and loading objects from files.
3. **Use ArrayList** to store lists in the repositories.
4. **Create appropriate methods** for adding data to repositories and generating sample resources and users.

## Sample Implementation

- **MenuService** – Class responsible for interacting with the user, allowing registration, login, renting, and returning resources. Implements the `MenuServiceInterface`.

- **ResourceService** and **UserService** – Classes responsible for saving and loading resource and user data from files. Implement the corresponding interfaces (`ResourceServiceInterface`, `UserServiceInterface`).

- **UserValidator** – Class responsible for validating user login data. Implements the `UserValidatorInterface`.

## Classes and Interfaces
- **ResourceServiceInterface** – Defines methods for managing resources (saving, loading).
- **UserServiceInterface** – Defines methods for managing users (saving, loading).
- **UserValidatorInterface** – Defines a method for validating users.

## Example Actions
1. **User Registration**: Enter user data, check email validity, add user to the repository.
2. **Login**: Check login and password validity, set the current user.
3. **Renting Resources**: Choose a resource from the list of available ones, add to the user's rentals, update the resource repository.
4. **Returning Resources**: Choose a resource to return, remove from the user's rentals, add back to the resource repository.

## Notes
- Ensure that all repository operations are synchronized and properly handled to avoid issues with multiple threads or read/write errors.
- Test the system in various scenarios to ensure all functionalities work correctly and without errors.

