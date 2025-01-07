Introduction
Coding Blox is an online coding platform that allows users to sign up, create coding contests, and participate in contests hosted by others. The platform manages users, questions, and contests while ensuring functionality for score calculation, leaderboards, and contest histories.

Functionalities
1. User Management
Command: CreateUser <user_name>
Description: Registers a new user with a default score of 1500.
Example:
CreateUser Ross
CreateUser Monica
2. Question Management
Command: CreateQuestion <difficulty_level> <score>

Description: Creates a new question with a specific difficulty level and score.

Auto-increment: Question IDs start from 1.

Example:

CreateQuestion LOW 10
CreateQuestion HIGH 50
Command: ListQuestion <difficulty_level>

Description: Lists all questions or filters them by difficulty level.

Example:

ListQuestion LOW
ListQuestion
3. Contest Management
Command: CreateContest <contest_name> <contest_level> <contest_creator_user_name>

Description: Creates a new contest with the given difficulty level and registers the creator as a participant.

Auto-increment: Contest IDs start from 1.

Example:

CreateContest "diwali_contest" LOW Ross
CreateContest "christmas_contest" HIGH Monica
Command: ListContest <difficulty_level>

Description: Lists all contests or filters them by difficulty level.

Example:

ListContest LOW
ListContest
4. Contest Participation
Command: AttendContest <contest_id> <user_name>

Description: Allows users to register for a contest. The creator is automatically registered.

Example:

AttendContest 1 Monica
AttendContest 1 Joey
Command: WithdrawContest <contest_id> <username>

Description: Allows users to withdraw from a contest before it starts. Creators cannot withdraw.

Example:

WithdrawContest 1 Joey
5. Running a Contest
Command: RunContest <contest_id> <contest_creator_user_name>
Description: Starts the contest if initiated by the creator. Updates user scores based on questions solved.
Score Calculation:
LOW: newScore = currentScore + (currentContestPoints - 50)
MEDIUM: newScore = currentScore + (currentContestPoints - 30)
HIGH: newScore = currentScore + (currentContestPoints)
Example:
RunContest 1 Ross
6. Leaderboard
Command: LeaderBoard <sorting_order>
Description: Displays a leaderboard sorted by score in ascending (asc) or descending (desc) order.
Example:
LeaderBoard desc
LeaderBoard asc
7. Contest History
Command: ContestHistory <contest_id>
Description: Displays contest results with user details, points secured, and questions solved.
Example:
ContestHistory 1
Output:
"Joey" : 65 [2,4,6]
"Ross" : 35 [1,3,5]
"Monica": 25 [1,3,6]
Bonus Functionalities
Randomized Question Solving: Generates random solved questions for each participant during the contest.
Robust Score Calculation: Final scores are derived using the formula based on contest difficulty.
Design Considerations
Modularity: Each functionality is implemented in its own class or method to ensure single responsibility.
Extensibility: Interfaces and contracts are used to allow easy addition or modification of features.
Error Handling: Edge cases are handled gracefully, ensuring robustness.
Readability: The code follows standard conventions and is DRY (Don’t Repeat Yourself).
Sample Data
Users: Ross, Monica, Joey, Chandler
Questions:
LOW: ID 1 (10 points), ID 2 (20 points)
MEDIUM: ID 3 (30 points)
HIGH: ID 4 (50 points)
Contests:
diwali_contest: LOW, Creator: Ross
Usage Instructions
Compile and run the program using a driver file or testing framework.
Use the provided commands to interact with the system.
Refer to examples for command structure and expected inputs.
Let me know if you want the implementation code or further details!
