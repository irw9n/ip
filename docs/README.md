# Ian User Guide

Hi! I'm ***Ian***, your personal task manager. I am a purely Command Line Interface (CLI) based interface that
allows you to keep track of your tasks in your life. I am a simple yet powerful tool that allows you to 
comfortably keep track of your life's schedule simply through a few clicks on the keyboard. So, what are
you waiting for? Launch me in your terminal and let's start making your life easier together!

## Quick Start

1. Ensure you have Java 17 in your Computer.
2. Download the latest `Ian.jar` file from [here](https://github.com/irw9n/ip/releases/tag/A-Release).
3. Copy the file to the folder of your choice as the home folder for your Ian task manager.
4. Open a command terminal, `cd` from the folder you have stored the jar file in, and run the `java -jar Ian.jar` command to run the application.
5. Type any command in the terminal and press Enter to execute it. e.g. typing `list` and pressing Enter will show all your tasks.
6. Refer to the [Features](#Features) below for the details of each command.

## Command Suite

Here are all the available commands within the application.  
Here are the available commands with their respective arguments (within <>):
1. `todo <description>`
2. `deadline <description> /by <date and time>`
3. `event <description> /from <start date and/or time> /to <end date and/or time>`
4. `list`
5. `mark <task number>`
6. `unmark <task number>`
7. `delete <task number>`
8. `find <keyword>`
9. `bye`  

## Features
## 1: Adding todo task: `todo`  
Adds a todo task with a description.    

**Example:**
```
todo read book
```  
**Expected output:**
```
Got it. I've added this task:
  [T][ ] read book
Now you have 1 task in the list.
``` 

## 2: Adding deadline task: `deadline`
Adds a deadline task with a description and deadline date and/or time.  

**Example:**
```
deadline submit assignment /by Friday 2359
```  
**Expected output:**
```
Got it. I've added this task:
  [D][ ] submit assignment (by: Friday 2359)
Now you have 2 tasks in the list.
``` 

## 3: Adding event task: `event`

Adds an event task with a description and start/end date/time.

**Example:**
```
event conference /from Sat 2pm /to Sat 4pm
```

**Expected output:**
```
Got it. I've added this task:
  [E][ ] conference (from: Sat 2pm to: Sat 4pm)
Now you have 3 tasks in the list.
```

## 4: List all tasks: `list`  

Lists all tasks added by the user in chronological order.  

**Example:**
```
list
```

**Expected output:**
```
Here are the tasks in your list:
1. [T][ ] read book
2. [D][ ] submit assignment (by: Friday 2359)
3. [E][ ] conference (from: Sat 2pm to: Sat 4pm)
```

## 5: Mark a task as completed: `mark`  
**Example:**
```
mark 3
```

**Expected output:**
```
Nice! I've marked this task as done:
   [E][X] conference (from: Sat 2pm to: Sat 4pm)
```

## 6: Unmark a task from completed to incomplete: `unmark`
**Example:**
```
unmark 3
```

**Expected output:**
```
OK, I've marked this task as not done yet:
   [E][ ] conference (from: Sat 2pm to: Sat 4pm)
```  

## 7: Delete a task from the list: `delete`
**Example:**
```
delete 3
```

**Expected output:**
```
Noted. I've removed this task:
  [E][ ] conference (from: Sat 2pm to: Sat 4pm)
Now you have 2 tasks in the list.
```  

## 8: Find tasks from a keyword: `find`
**Example:**
```
find assignment
```

**Expected output:**
```
Here are the matching tasks in your list:
1. [D][ ]  submit assignment (by: Friday 2359)
```  

## 9: Exit application: `bye`
**Example:**
```
bye
```

**Expected output:**
```
Bye. Hope to see you again soon!
```   

## Data Storage

Ian automatically saves your list of tasks into a file located at
`./data/tasks.txt` upon the end of every program, so you don't have to worry about
data loss. Upon startup, the program then loads the `tasks.txt` file and allows you
to view and interact with all your tasks once again.


