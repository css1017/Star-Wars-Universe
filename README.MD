# Star Wars Universe

Welcome to the Star Wars Universe repository! This Android application provides detailed information about Star Wars movies, characters, and planets using the [SWAPI](https://swapi.dev) API. The app is built using Kotlin and follows MVVM architecture with Room for local database storage.

## Features

### Screen 1: Movies List
- Displays a list of Star Wars movies.
- Fetches movie data from the SWAPI API and stores it in a local Room database for offline access.
- Movies are sorted by episode number.
- Each list item shows the movie title (bold black), director, producer, and release date (italic red).
- Includes a search bar to filter movies by title.
- Tapping on a movie navigates to the Characters screen.

### Screen 2: Characters List
- Shows a list of characters in the selected movie.
- Displays the selected movie's title in the status bar.
- Fetches character data from the SWAPI API and stores it in the local Room database.
- Each list item shows the character's name (bold), gender, and birth year.
- Tapping on a character navigates to the Planet screen.

### Screen 3: Planet Details
- Displays detailed information about the character's home planet.
- Fetches planet data from the SWAPI API and stores it in the local Room database.
- Shows planet details including name, diameter, climate, gravity, terrain, and population.
- Includes navigation back to the Characters screen.

## API Endpoints
- **Movies**: [https://swapi.dev/api/films/](https://swapi.dev/api/films/)
- **Character**: [https://swapi.dev/api/people/{id}/](https://swapi.dev/api/people/{id}/)
- **Planet**: [https://swapi.dev/api/planets/{id}/](https://swapi.dev/api/planets/{id}/)

## Local Database
The application uses Room for local database storage. Data is fetched from the SWAPI API and stored locally to reduce internet usage and provide offline access.

## Development Process
The development process is documented through multiple commits, detailing each phase of the project. This includes initial setup, API integration, database implementation, UI development, and edge case handling.

