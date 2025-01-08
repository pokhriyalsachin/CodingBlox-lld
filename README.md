# Coding Blox

## Overview
Coding Blox is an online coding platform enabling users to create and participate in coding contests. The platform supports user management, question creation, contest hosting, leaderboard generation, and contest histories while ensuring robust score calculation and random question-solving capabilities.

## Functionalities

### Core Functionalities

#### 1. User Management
- **Command:** `CreateUser <user_name>`
- **Description:** Registers a new user with a default score of 1500.
- **Example:**
  - `CreateUser Ross`
  - `CreateUser Monica`

#### 2. Question Management
- **Command:** `CreateQuestion <difficulty_level>`
- **Description:** Creates a new question with a specific difficulty level and score.
- **Auto-increment:** Question IDs start from 1.
- **Example:**
  - `CreateQuestion LOW 10`
  - `CreateQuestion HIGH 50`

- **Command:** `ListQuestion <difficulty_level>`
- **Description:** Lists all questions or filters them by difficulty level.
- **Example:**
  - `ListQuestion LOW`

#### 3. Contest Management
- **Command:** `CreateContest <contest_name> <contest_level> <contest_creator_user_name>`
- **Description:** Creates a new contest with the given difficulty level and registers the creator as a participant.
- **Auto-increment:** Contest IDs start from 1.
- **Example:**
  - `CreateContest "diwali_contest" LOW Ross`
  - `CreateContest "christmas_contest" HIGH Monica`

- **Command:** `ListContest <difficulty_level>`
- **Description:** Lists all contests or filters them by difficulty level.
- **Example:**
  - `ListContest LOW`

#### 4. Contest Participation
- **Command:** `AttendContest <contest_id> <user_name>`
- **Description:** Allows users to register for a contest. The creator is automatically registered.
- **Example:**
  - `AttendContest 1 Monica`

- **Command:** `WithdrawContest <contest_id>`
- **Description:** Allows users to withdraw from a contest before it starts. Creators cannot withdraw.
- **Example:**
  - `WithdrawContest 1 Joey`

#### 5. Running a Contest
- **Command:** `RunContest <contest_id> <contest_creator_user_name>`
- **Description:** Starts the contest if initiated by the creator. Updates user scores based on questions solved.
- **Score Calculation:**
  - **LOW:** `newScore = currentScore + (currentContestPoints - 50)`
  - **MEDIUM:** `newScore = currentScore + (currentContestPoints - 30)`
  - **HIGH:** `newScore = currentScore + (currentContestPoints)`
- **Example:**
  - `RunContest 1 Ross`

#### 6. Leaderboard
- **Command:** `LeaderBoard <sorting_order>`
- **Description:** Displays a leaderboard sorted by score in ascending (`asc`) or descending (`desc`) order.
- **Example:**
  - `LeaderBoard desc`
  - `LeaderBoard asc`

#### 7. Contest History
- **Command:** `ContestHistory <contest_id>`
- **Description:** Displays contest results with user details, points secured, and questions solved.
- **Example:**
  - `ContestHistory 1`
  - **Output:**
    - `"Joey" : 65 [2,4,6]`
    - `"Ross" : 35 [1,3,5]`
    - `"Monica": 25 [1,3,6]`

### Bonus Functionalities

#### 1. Randomized Question Solving
- Generates random solved questions for each participant during the contest.

#### 2. Robust Score Calculation
- Uses difficulty-based formulas to calculate final scores effectively.

## Design Considerations

### Key Principles
1. **Modularity:** Each functionality is implemented in separate classes or methods to ensure single responsibility.
2. **Extensibility:** Interfaces and contracts are used to add or modify features easily.
3. **Error Handling:** Graceful handling of edge cases ensures robustness.
4. **Readability:** Code follows standard conventions and adheres to DRY (Don’t Repeat Yourself).

### Classes and Attributes
1. **User:**
   - Attributes: `name`, `score`.
2. **Question:**
   - Attributes: `id`, `difficulty_level`, `score`.
3. **Contest:**
   - Attributes: `id`, `name`, `difficulty_level`, `creator`, `participants`, `questions`.
4. **ContestSystem:**
   - Manages users, questions, contests, and interactions.

### Contracts/Interfaces
- **User Interface:** Methods for user registration.
- **Question Interface:** Methods for adding and listing questions.
- **Contest Interface:** Methods for creating, running, and retrieving contest details.
- **Leaderboard Interface:** For displaying user scores.

### Edge Cases
1. User tries to attend a contest already attended.
2. Contest creator attempts to withdraw.
3. User solves no questions during the contest.
4. Randomized question solving generates invalid scores.

## Sample Data
1. **Users:**
   - Ross, Monica, Joey, Chandler
2. **Questions:**
   - **LOW:** ID 1 (10 points), ID 2 (20 points)
   - **MEDIUM:** ID 3 (30 points)
   - **HIGH:** ID 4 (50 points)
3. **Contests:**
   - `diwali_contest`: LOW, Creator: Ross

## Usage Instructions
1. Compile and run the program using the main driver file.
2. Use provided commands to interact with the system.
3. Verify outputs using sample data and edge cases.

## Next Steps
1. Implement the outlined classes and interfaces.
2. Write test cases for all functionalities.
3. Build a CLI or web interface for user interaction.
4. Document the implementation for future reference.

