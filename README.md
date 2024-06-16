# Player API

This is a Spring Boot application for managing player data.

## Endpoints

### GET /api/players

Returns the list of all players with pagination.

- **Parameters:**
    - `page` (optional): The page number (default: 0).
    - `size` (optional): The number of items per page (default: 100).

### GET /api/players/{playerID}

Returns a single player by ID.

## Frontend

### Fetch All Players

Navigate to `http://localhost:8081/fetch-all.html` to view all players with pagination.

### Fetch Player by ID

Navigate to `http://localhost:8081/fetch-by-id.html` to view a player by their ID.

## Setup

1. **Clone the repository:**
   ```sh
   git clone https://github.com/YOUR_USERNAME/player-api.git
   cd player-api
