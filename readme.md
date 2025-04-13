# Social Media Blog API

## Project Description

This social media application will serve as a backend API, providing the infrastructure to manage user accounts and their messages. While there won’t be a frontend, the backend will enable users to view all messages on the platform or filter messages by specific users. The API will also handle key actions such as user logins, registrations, and allow users to create, update, or delete messages. Essentially, this backend will power the data flow and operations needed for a smooth and interactive experience, focusing on user management and message handling.

## Technologies Used

* Java - java 23.0.2 2025-01-21
* Maven - apache maven 3.0.0-M7
* h2database - h2 2.1.214
* Javalin - javalin 5.0.1
* JUnit - junit 4.13.2
* Mockito - mockito 4.9.0

## Features

List of features
* Adding a user
* Login
* Creating a message
* Get all messages
* Get a specific message
* Delete a specific message
* Update a specific message
* Get messages for a user

To-do list:
* Implement frontend GUI

## Getting Started

Windows:
1. Install Git (if not already installed)
    Download from: https://git-scm.com/download/win

2. You can either:
    a. Open Git Bash and navigate to the directory where you want to clone the repo.
    b. Navigate to the directory where you want to clone the repo, right-click inside the folder, and select “Git Bash Here.”
Note: Use "cd /c/Users/YourName/Path/To/Folder" to change directories.

3. Clone the repository
git clone https://github.com/josephxnassar/Social-Media-Blog-API.git

Linux:
1. Install Git (if not already installed)
sudo apt update && sudo apt install git

2. Open terminal and navigate to the directory where you want to clone the repo
Note: Use "cd /c/Users/YourName/Path/To/Folder" to change directories.

3. Clone the repository
git clone https://github.com/josephxnassar/Social-Media-Blog-API.git

## Usage

After installation, it's important to understand the structure of the project:

Main.java initializes the Javalin web server and serves as the entry point for the controller layer. Updates here are rare and typically unnecessary.

SocialMediaController.java represents the controller layer. It defines the API endpoints that the client can send requests to, along with the corresponding handler functions. If you want to add new endpoints or create handler functions, this is where you'll do it.

AccountService.java and MessageService.java make up the service layer. They act as a bridge between the controller and DAO layers. Any new functionality added in the controller should be linked through the service layer.

AccountDAO.java and MessageDAO.java represent the DAO (Data Access Object) layer. These classes interact directly with the database to perform operations such as searching, adding, updating, and deleting data. If you modify the service layer, you'll need to implement the corresponding logic here.

Account.java and Message.java are model classes representing an account and a message in the database. If you want to introduce a new database feature or entity, this is where you'd define its structure.

## License

This project uses the following license: [<LICENSE>](</workspace/josephxnassar-pep-project/LICENSE.txt>).