#                                 A Event Coordination Mobile Application

 EventCoordinator is a mobile app designed to streamline event planning and execution. Key features include event creation, guest list management, task assignment, notifications, budget tracking, vendor coordination, and real-time updates. Built with React Native, Node.js, and MongoDB for a seamless, cross-platform experience.


# # Features

# Event Creation and Management: 

Quickly create and manage events with detailed information, including date, time, location, and description, all within the intuitive Android Studio interface. Organize events into categories and customize settings for each event, ensuring flexibility and personalized management.

# Guest List Management: 

Easily invite guests, track RSVPs, and manage attendee details with real-time updates, enhancing communication and organization for your event. Categorize guests into groups, assign privileges, and customize access levels for enhanced security and control over event access.

# Task Assignment: 

Delegate tasks to team members, set deadlines, and monitor progress within the Android Studio environment, ensuring effective collaboration and task management. Assign tasks based on roles or categories, track task dependencies, and receive notifications for task updates and completions to ensure smooth workflow coordination.

# Notifications and Reminders:

Automate notifications and reminders to keep your team and guests informed of important updates and deadlines, enhancing communication and reducing the risk of missed information. Customize notification preferences, schedule reminders for key milestones, and send personalized messages to specific groups or individuals to ensure timely communication and engagement.

# Budget Tracking: 

Manage your event budget efficiently with built-in expense tracking and financial reporting tools, all seamlessly integrated into the Android Studio app interface. Set budget limits, track expenses in real time, generate expense reports, and monitor spending trends to ensure optimal budget management and financial transparency throughout the event planning process.

# Vendor Coordination: 

Maintain a directory of vendors, manage communications, and track contracts and agreements, all from within the Android Studio app, simplifying vendor coordination and management. Store vendor contact information, track vendor interactions and communications, and manage vendor contracts and payments, streamlining the vendor management process and ensuring smooth collaboration with all stakeholders.

# Venue Mapping: 

Provide detailed maps and directions to your event venue, ensuring guests can easily find their way, with integrated mapping features within the Android Studio app. Customize venue maps with event-specific information, highlight key locations and amenities, and provide interactive navigation features to enhance the guest experience and minimize logistical challenges.

# Real-Time Updates: 

Make instant updates to event details and notify attendees of any changes in real time, ensuring everyone stays informed and up-to-date throughout the event planning process. Update event schedules, locations, and other details on the fly, send push notifications to attendees with event updates and announcements, and provide real-time chat support for immediate assistance and communication with event participants.

# # Technologies

# Frontend/UI: 
The user interface is designed with Android Studio, providing a seamless and intuitive experience on Android devices. Utilizing XML layouts and Android Jetpack components, the UI is responsive and user-friendly.

# Backend Development: 
The backend is developed using Node.js and Express, providing robust and scalable server-side operations. These technologies ensure efficient handling of event data, task assignments, notifications, and real-time updates.

# Database: 
The application uses Firebase for its database needs. Firebase offers real-time data synchronization, ensuring that all event details, 
guest lists, and other critical data are always up-to-date and accessible from any device.

# User Registration and Authentication: 

User registration and authentication are handled through Firebase Authentication. 

This service provides secure and reliable user login and management, supporting email/password, phone, and social media login methods to ensure a smooth and secure authentication process.

# # Getting Started

To get started with the EventCoordinator application, follow these steps:

# Prerequisites

Before you begin, ensure you have the following installed on your system:

Node.js and npm: Node.js is required to run the backend server, and npm is needed to manage dependencies.

Android Studio: Required for building and running the Android app.

Firebase Account: Needed for database and authentication services.

Git: For version control and cloning the repository.

# Installation Steps

# 1. Clone the Repository

First, clone the EventCoordinator repository from GitHub to your local machine using the following command:

git clone https://github.com/yourusername/EventCoordinator.git

# 2. Navigate to the Project Directory

Change into the project directory:

cd EventCoordinator

# 3. Install Backend Dependencies

Install the required Node.js dependencies for the backend:

npm install

# 4. Set Up Firebase

Create a new project in the Firebase Console.

Enable Firebase Authentication and choose your preferred sign-in methods.

Set up a Firestore database.

Obtain your Firebase project’s configuration details and update the firebaseConfig object in your project.

Create a file named .env in the root of your project directory and add the Firebase configuration details:


FIREBASE_API_KEY=your_api_key

FIREBASE_AUTH_DOMAIN=your_project_id.firebaseapp.com

FIREBASE_PROJECT_ID=your_project_id

FIREBASE_STORAGE_BUCKET=your_project_id.appspot.com

FIREBASE_MESSAGING_SENDER_ID=your_messaging_sender_id

FIREBASE_APP_ID=your_app_id


# 5. Start the Backend Server

Start the backend server to handle API requests and interact with the Firebase database:

npm start

The backend server should now be running on http://localhost:3000.

# 6. Open the Project in Android Studio

Launch Android Studio.

Open the EventCoordinator project by selecting the project directory.

Allow Android Studio to sync and build the project, installing any required dependencies.

# 7. Configure Firebase in Android Studio

Add the google-services.json file (downloaded from Firebase Console) to the app directory in your Android Studio project.

Ensure your build.gradle files (both project-level and app-level) include the necessary Firebase dependencies:
gradle


// Project-level build.gradle

classpath 'com.google.gms:google-services:4.3.10' // or the latest version

// App-level build.gradle

apply plugin: 'com.google.gms.google-services'

dependencies {

    implementation 'com.google.firebase:firebase-auth:21.0.1' // or the latest version
    
    implementation 'com.google.firebase:firebase-firestore:24.0.1' // or the latest version
}


# 8. Run the Android App

Connect an Android device to your computer or set up an Android emulator.

Click on the "Run" button in Android Studio, or use the following command to build and run the app:

./gradlew assembleDebug

The app should now be installed and running on your Android device or emulator.


# # Testing and Usage
User Registration and Authentication: Open the app and register a new user or log in with existing credentials.

Event Management: Start creating, managing, and organizing your events through the user-friendly interface.

Real-Time Updates: Make changes and see real-time updates across all devices connected to the app.

# #Troubleshooting

Common Issues:

Ensure all Firebase services are correctly set up and configured.

Verify that the google-services.json file is in the correct location and properly formatted.

Make sure the backend server is running and accessible.
