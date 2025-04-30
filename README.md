# SeatArrangementSystem

1. User Stories for Real-Time Scenarios
User stories describe the needs of stakeholders (primarily the Admin, i.e., college staff) in various real-time scenarios. Below are user stories categorized by key functionalities.
Epic 1: Admin Authentication
User Story 1.1: As an admin, I want to log in to the system using my credentials so that only authorized personnel can manage seat arrangements.
Scenario: Admin enters a valid username and password to access the system.

Acceptance Criteria:
System prompts for username and password.

Valid credentials grant access; invalid credentials display an error.

User Story 1.2: As an admin, I want to log out after completing my tasks so that the system remains secure.
Scenario: Admin finishes generating a seating plan and logs out to prevent unauthorized access.

Acceptance Criteria:
System provides a logout option.

After logout, login is required to access the system again.

Epic 2: Data Input
User Story 2.1: As an admin, I want to import student data from a CSV file so that I can quickly load large datasets without manual entry.
Scenario: Admin uploads a CSV file containing student details (roll number, name, department, semester).

Acceptance Criteria:
System validates the file format and content.

Successful import displays a confirmation; errors show specific issues (e.g., missing fields).

User Story 2.2: As an admin, I want to manually enter student data so that I can add or edit student details when a file is unavailable.
Scenario: Admin enters student details via the console for a small group of students.

Acceptance Criteria:
System prompts for roll number, name, department, and semester.

Input is validated (e.g., no duplicate roll numbers).

Admin can review and confirm entries.

User Story 2.3: As an admin, I want to import room data from a CSV file so that I can efficiently set up exam rooms.
Scenario: Admin uploads a CSV file with room details (room number, rows, columns).

Acceptance Criteria:
System validates room data (e.g., positive rows/columns, unique room numbers).

Errors are reported clearly.

User Story 2.4: As an admin, I want to manually enter room data so that I can configure rooms without a file.
Scenario: Admin enters room details for a single exam venue.

Acceptance Criteria:
System prompts for room number, rows, and columns.

Input is validated (e.g., capacity calculated correctly).

Epic 3: Seat Allocation
User Story 3.1: As an admin, I want to set seating preferences (e.g., spacing, mixing departments) so that the arrangement meets institutional requirements.
Scenario: Admin selects options like single-seat spacing or cross-department seating before allocation.

Acceptance Criteria:
System provides a menu to choose preferences.

Preferences are applied during allocation.

User Story 3.2: As an admin, I want to automatically allocate students to seats so that I don’t have to manually assign each student.
Scenario: Admin initiates the allocation process after loading student and room data.

Acceptance Criteria:
System assigns each student a unique seat (room, row, column).

Allocation respects preferences and room capacities.

Errors (e.g., insufficient seats) are reported.

User Story 3.3: As an admin, I want to preview the seating plan in the console so that I can verify it before generating the final output.
Scenario: Admin reviews a draft seating arrangement to ensure it meets requirements.

Acceptance Criteria:
System displays a room-wise seating layout in a readable format.

Admin can confirm or re-run allocation with different preferences.

Epic 4: Output Generation
User Story 4.1: As an admin, I want to export the seating plan as a PDF so that I can print it for exam use.
Scenario: Admin generates a PDF with room-wise seating details for distribution.

Acceptance Criteria:
PDF includes room number, seat positions, and student details (roll number, name).

Output is formatted clearly (e.g., tables or grids).

File is saved to the output/ directory.

User Story 4.2: As an admin, I want to view the seating plan in the console so that I can quickly check the arrangement without generating a PDF.
Scenario: Admin checks the allocation for a specific room during planning.

Acceptance Criteria:
System prints a formatted seating layout for each room.

Output is easy to read (e.g., tabular format).

2. Functional and Non-Functional Requirements
Functional Requirements
Admin Authentication:
The system must allow the admin to log in with a username and password.

The system must support logout functionality.

Data Input:
The system must support importing student data (roll number, name, department, semester) from a CSV file.

The system must allow manual entry of student data via the console.

The system must support importing room data (room number, rows, columns) from a CSV file.

The system must allow manual entry of room data via the console.

Seat Allocation:
The system must allocate students to seats based on custom preferences (e.g., spacing, mixing departments/semesters).

The system must ensure each student is assigned a unique seat (room, row, column).

The system must validate that the number of students does not exceed room capacities.

The system must allow the admin to preview the seating plan in the console.

Output Generation:
The system must generate a PDF file with the seating arrangement, including room-wise student details.

The system must display the seating arrangement in the console on demand.

Non-Functional Requirements
Usability:
The system must have a simple console-based interface (CLI) that is easy for college staff to use.

Performance:
The system must efficiently handle large datasets (e.g., up to 10,000 students and 100 rooms).

The seating plan generation must complete within 10 seconds for typical datasets.

Reliability:
The system must include error handling for invalid inputs (e.g., malformed files, duplicate roll numbers).

The system must ensure no data loss during processing.

Maintainability:
The codebase must be modular and follow OOP principles for easy updates.

Output Quality:
The generated PDF must be clean, well-formatted, and suitable for printing.

Portability:
The system must run on any platform supporting Java (e.g., Windows, Linux).

Security:
Admin credentials must be stored securely (e.g., hashed passwords).

Only authenticated users can access the system.

3. User Stories from Functional Requirements
The user stories in Section 1 already map directly to the functional requirements. Each epic (Admin Authentication, Data Input, Seat Allocation, Output Generation) corresponds to a functional requirement, and the user stories within each epic detail specific scenarios. For clarity, here’s a mapping:
Functional Requirement 1 (Admin Authentication):
User Story 1.1 (Login)

User Story 1.2 (Logout)

Functional Requirement 2 (Data Input):
User Story 2.1 (Import Student Data)

User Story 2.2 (Manual Student Data Entry)

User Story 2.3 (Import Room Data)

User Story 2.4 (Manual Room Data Entry)

Functional Requirement 3 (Seat Allocation):
User Story 3.1 (Set Preferences)

User Story 3.2 (Automatic Allocation)

User Story 3.3 (Preview Seating Plan)

Functional Requirement 4 (Output Generation):
User Story 4.1 (Export PDF)

User Story 4.2 (View in Console)

4. Use Case Diagrams from Epics
Below is a textual description of the Use Case Diagram for the system, based on the four epics. The diagram includes the Admin as the primary actor interacting with use cases.
Use Case Diagram Description
Actor: Admin

System Boundary: College Exam Seat Arrangement System

Use Cases (grouped by Epic):
Admin Authentication:
Log In

Log Out

Data Input:
Import Student Data

Enter Student Data Manually

Import Room Data

Enter Room Data Manually

Seat Allocation:
Set Seating Preferences

Allocate Seats

Preview Seating Plan

Output Generation:
Generate PDF

View Seating Plan in Console

Relationships:
Log In is a prerequisite for all other use cases (extends relationship).

Allocate Seats includes Set Seating Preferences (since preferences must be set before allocation).

Generate PDF and View Seating Plan in Console depend on Allocate Seats (extends relationship).

Visualization (Text-Based)

[Admin] ----> (Log In)
[Admin] ----> (Log Out)
[Admin] ----> (Import Student Data)
[Admin] ----> (Enter Student Data Manually)
[Admin] ----> (Import Room Data)
[Admin] ----> (Enter Room Data Manually)
[Admin] ----> (Set Seating Preferences) ----> (Allocate Seats)
[Admin] ----> (Preview Seating Plan)
[Admin] ----> (Generate PDF)
[Admin] ----> (View Seating Plan in Console)

Note: In a graphical UML tool (e.g., Lucidchart, StarUML), this would be represented with an actor (stick figure) connected to ovals (use cases) within a system boundary, with arrows indicating relationships.
5. Class Diagrams for Use Cases
The class diagram provided in your project summary is already well-suited to support the use cases. Below, I refine it to ensure all use cases are covered and provide a textual description. The diagram includes classes, attributes, methods, and relationships.
Class Diagram Description
Classes and Attributes:
Admin:
Attributes: username: String, password: String

Methods: login(inputUser: String, inputPass: String): boolean, logout(): void

Student:
Attributes: rollNo: String, name: String, department: String, semester: int

Methods: Constructor, getters/setters

Room:
Attributes: roomNumber: String, rows: int, columns: int, capacity: int

Methods: Constructor, getters/setters

StudentManager:
Attributes: studentList: List<Student>

Methods: loadStudentsFromFile(filePath: String): void, addStudent(student: Student): void, getStudents(): List<Student>

RoomManager:
Attributes: roomList: List<Room>

Methods: loadRoomsFromFile(filePath: String): void, addRoom(room: Room): void, getRooms(): List<Room>

SeatAllocator:
Attributes: studentManager: StudentManager, roomManager: RoomManager, seatingPlan: Map<Room, List<SeatedStudent>>

Methods: setPreferences(prefs: Preferences): void, allocateSeats(): void, getSeatingPlan(): Map<Room, List<SeatedStudent>>

SeatedStudent:
Attributes: student: Student, room: Room, row: int, column: int

Methods: Constructor, getters/setters, toString(): String

PDFGenerator:
Attributes: seatingPlan: Map<Room, List<SeatedStudent>>

Methods: generatePDF(outputPath: String): void

Preferences (new class to support customizable seating rules):
Attributes: spacing: boolean, mixDepartments: boolean, mixSemesters: boolean

Methods: Constructor, getters/setters

Relationships:
Admin → Uses StudentManager, RoomManager, SeatAllocator (association).

StudentManager → Manages Student (composition, 1-to-many).

RoomManager → Manages Room (composition, 1-to-many).

SeatAllocator → Uses StudentManager, RoomManager (association); creates SeatedStudent (aggregation).

PDFGenerator → Uses SeatedStudent (association via seatingPlan).

SeatedStudent → References Student and Room (association).

Visualization (Text-Based)

[Admin]
  | username: String
  | password: String
  + login(inputUser: String, inputPass: String): boolean
  + logout(): void
  --> [StudentManager], [RoomManager], [SeatAllocator]

[StudentManager]
  | studentList: List<Student>
  + loadStudentsFromFile(filePath: String): void
  + addStudent(student: Student): void
  + getStudents(): List<Student>
  --> [Student] (1..*)

[RoomManager]
  | roomList: List<Room>
  + loadRoomsFromFile(filePath: String): void
  + addRoom(room: Room): void
  + getRooms(): List<Room>
  --> [Room] (1..*)

[Student]
  | rollNo: String
  | name: String
  | department: String
  | semester: int
  + Constructor, getters/setters

[Room]
  | roomNumber: String
  | rows: int
  | columns: int
  | capacity: int
  + Constructor, getters/setters

[SeatAllocator]
  | studentManager: StudentManager
  | roomManager: RoomManager
  | seatingPlan: Map<Room, List<SeatedStudent>>
  + setPreferences(prefs: Preferences): void
  + allocateSeats(): void
  + getSeatingPlan(): Map<Room, List<SeatedStudent>>
  --> [StudentManager], [RoomManager], [SeatedStudent], [Preferences]

[SeatedStudent]
  | student: Student
  | room: Room
  | row: int
  | column: int
  + Constructor, getters/setters, toString(): String
  --> [Student], [Room]

[PDFGenerator]
  | seatingPlan: Map<Room, List<SeatedStudent>>
  + generatePDF(outputPath: String): void
  --> [SeatedStudent]

[Preferences]
  | spacing: boolean
  | mixDepartments: boolean
  | mixSemesters: boolean
  + Constructor, getters/setters

Note: This diagram can be visualized in a UML tool by drawing classes as boxes, attributes/methods inside, and arrows for relationships (e.g., solid line for composition, dashed for association).
6. Sequence Diagrams for Class Diagrams
Sequence diagrams illustrate the interactions between objects for key use cases. Below are sequence diagrams for two critical use cases: Allocate Seats and Generate PDF.
Sequence Diagram 1: Allocate Seats
Actors/Objects: Admin, Main, StudentManager, RoomManager, SeatAllocator, Preferences, SeatedStudent

Steps:
Admin calls startAllocation() on Main.

Main calls loadStudentsFromFile(filePath) on StudentManager.

StudentManager loads and validates student data, returns studentList.

Main calls loadRoomsFromFile(filePath) on RoomManager.

RoomManager loads and validates room data, returns roomList.

Main creates a Preferences object with user-specified settings (e.g., spacing=true).

Main calls setPreferences(prefs) on SeatAllocator.

Main calls allocateSeats() on SeatAllocator.

SeatAllocator retrieves studentList from StudentManager and roomList from RoomManager.

SeatAllocator creates SeatedStudent instances for each student, assigning them to rooms and seats.

SeatAllocator updates seatingPlan and returns it to Main.

Main displays the plan in the console (optional).

Visualization (Text-Based)

Admin   Main   StudentManager   RoomManager   SeatAllocator   Preferences   SeatedStudent
  |       |          |             |              |              |             |
  | startAllocation() |             |              |              |             |
  |------>|          |             |              |              |             |
  |       | loadStudentsFromFile() |              |              |             |
  |       |--------->|             |              |              |             |
  |       |          | return studentList |       |              |             |
  |       |<---------|             |              |              |             |
  |       |          |             | loadRoomsFromFile() |       |             |
  |       |          |             |------------->|              |             |
  |       |          |             | return roomList |         |             |
  |       |          |             |<-------------|              |             |
  |       | create Preferences |   |              |              |             |
  |       |------------------------------->|              |             |
  |       |          |             |              | setPreferences(prefs) |
  |       |          |             |              |------------->|             |
  |       |          |             |              | allocateSeats() |         |
  |       |          |             |              |------------->|             |
  |       |          | getStudents()|              |              |             |
  |       |          |<------------|              |              |             |
  |       |          |             | getRooms()   |              |             |
  |       |          |             |<-------------|              |             |
  |       |          |             |              | create SeatedStudent |    |
  |       |          |             |              |--------------------->|    |
  |       |          |             |              | update seatingPlan |      |
  |       |          |             |              |<---------------------|    |
  |       |          |             |              | return seatingPlan |      |
  |       |          |             |              |<-------------|             |
  |       | displayPlan() |       |              |              |             |
  |       |<---------|             |              |              |             |

Sequence Diagram 2: Generate PDF
Actors/Objects: Admin, Main, SeatAllocator, PDFGenerator

Steps:
Admin calls generatePDF() on Main.

Main calls getSeatingPlan() on SeatAllocator.

SeatAllocator returns seatingPlan.

Main creates a PDFGenerator with seatingPlan.

Main calls generatePDF(outputPath) on PDFGenerator.

PDFGenerator formats the seating plan into a PDF using iText.

PDFGenerator saves the file and returns success.

Main notifies Admin of successful PDF generation.

Visualization (Text-Based)

Admin   Main   SeatAllocator   PDFGenerator
  |       |          |             |
  | generatePDF() |          |             |
  |------>|          |             |
  |       | getSeatingPlan() |          |
  |       |--------->|             |
  |       |          | return seatingPlan |
  |       |<---------|             |
  |       | create PDFGenerator |   |
  |       |--------------------->|   |
  |       | generatePDF(outputPath) |
  |       |--------------------->|   |
  |       |          |             | [iText: create PDF]
  |       |          |             | [save file]
  |       |          |             | return success
  |       |<---------------------|   |
  |       | notifySuccess() |       |
  |       |<---------|             |

Note: These diagrams can be drawn in UML tools with lifelines (vertical dashed lines) for each object and arrows for messages.
7. Object States and State Chart Diagrams
State chart diagrams describe the states an object can be in and transitions between them. Below, I identify states for key classes and provide state chart diagrams.
Object 1: Student
States:
Unallocated: Student is loaded but not assigned a seat.

Allocated: Student is assigned a seat (room, row, column).

Transitions:
Unallocated → Allocated: When SeatAllocator assigns the student a seat.

Allocated → Unallocated: If allocation is reset (e.g., re-run with new preferences).

State Chart Diagram (Text-Based)

[Unallocated] --> [Allocated] : allocateSeats()
[Allocated] --> [Unallocated] : resetAllocation()

Object 2: Room
States:
Empty: Room is defined but has no students assigned.

Partially Filled: Some seats are assigned to students.

Fully Filled: All seats are assigned.

Transitions:
Empty → Partially Filled: When SeatAllocator assigns the first student.

Partially Filled → Fully Filled: When all seats are assigned.

Partially Filled → Empty: If allocation is reset.

Fully Filled → Empty: If allocation is reset.

State Chart Diagram (Text-Based)

[Empty] --> [Partially Filled] : assignFirstStudent()
[Partially Filled] --> [Fully Filled] : assignAllSeats()
[Partially Filled] --> [Empty] : resetAllocation()
[Fully Filled] --> [Empty] : resetAllocation()

Object 3: SeatedStudent
States:
Created: Instance is created with student, room, row, and column.

Printed: Instance is included in console output or PDF.

Transitions:
Created → Printed: When PDFGenerator or console output uses the instance.

Printed → Created: If allocation is reset and re-generated.

State Chart Diagram (Text-Based)

[Created] --> [Printed] : generatePDF() or displayPlan()
[Printed] --> [Created] : resetAllocation()

Note: These diagrams can be visualized as state boxes connected by arrows with transition labels in a UML tool.
8. Activities and Activity Diagrams
Activity diagrams model the workflow for key actions in the system. Below are activity diagrams for two critical actions: Allocate Seats and Generate PDF.
Activity Diagram 1: Allocate Seats
Activities:
Start allocation process.

Load student data.

Validate student data.

Load room data.

Validate room data.

Set seating preferences.

Check if enough seats are available.

Allocate students to seats.

Create seating plan.

Display plan in console (optional).

End process.

Decision Points:
Valid student data? (Yes/No)

Valid room data? (Yes/No)

Enough seats? (Yes/No)

Flows:
If data is invalid, display error and end.

If insufficient seats, display error and end.

Visualization (Text-Based)

[Start]
   |
[Load Student Data]
   |
[Validate Student Data]
   | Yes
   | No --> [Display Error] --> [End]
   |
[Load Room Data]
   |
[Validate Room Data]
   | Yes
   | No --> [Display Error] --> [End]
   |
[Set Seating Preferences]
   |
[Check Enough Seats]
   | Yes
   | No --> [Display Error] --> [End]
   |
[Allocate Students to Seats]
   |
[Create Seating Plan]
   |
[Display Plan in Console]
   |
[End]

Activity Diagram 2: Generate PDF
Activities:
Start PDF generation.

Retrieve seating plan.

Validate seating plan.

Create PDF document.

Add seating details to PDF.

Save PDF file.

Notify success.

End process.

Decision Points:
Valid seating plan? (Yes/No)

Flows:
If seating plan is invalid, display error and end.

Visualization (Text-Based)

[Start]
   |
[Retrieve Seating Plan]
   |
[Validate Seating Plan]
   | Yes
   | No --> [Display Error] --> [End]
   |
[Create PDF Document]
   |
[Add Seating Details to PDF]
   |
[Save PDF File]
   |
[Notify Success]
   |
[End]

Note: These diagrams can be drawn in UML tools with rounded rectangles for activities, diamonds for decision points, and arrows for flows.
 Summary of Documentation
This documentation provides a complete analysis of the College Exam Seat Arrangement System, including:
User Stories: Detailed scenarios for admin interactions, covering authentication, data input, seat allocation, and output generation.

Requirements: Clear functional and non-functional requirements, aligned with the project’s goals.

User Stories from Requirements: Mapped directly to functional requirements.

Use Case Diagram: Visualizes admin interactions with the system.

Class Diagram: Refines the provided UML diagram to support all use cases.

Sequence Diagrams: Illustrates object interactions for key use cases (Allocate Seats, Generate PDF).

State Chart Diagrams: Describes state transitions for Student, Room, and SeatedStudent.

Activity Diagrams: Models workflows for Allocate Seats and Generate PDF actions.



