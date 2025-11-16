"""
A simple command-line tool to manage housing stabilization clients.

This script demonstrates basic programming skills and problem solving by providing
a minimal system to track client information, case notes, and tasks. Each client
is stored as a dictionary inside a list, and the user can add clients, view
existing clients, update notes, and remove clients. This project simulates
practical use of data structures (lists and dictionaries) and functions to
organize information—a fundamental skill in project management and IT.
"""

from typing import List, Dict


class ClientManagementSystem:
    """A simple in-memory client management system."""

    def __init__(self):
        self.clients: List[Dict[str, str]] = []

    def add_client(self, name: str, phone: str, notes: str = "") -> None:
        client = {"name": name, "phone": phone, "notes": notes, "tasks": []}
        self.clients.append(client)
        print(f"Added client: {name}")

    def list_clients(self) -> None:
        if not self.clients:
            print("No clients found.")
            return
        for idx, client in enumerate(self.clients, start=1):
            print(f"{idx}. {client['name']} – Phone: {client['phone']} – Notes: {client['notes']}")

    def update_notes(self, index: int, new_notes: str) -> None:
        if 0 <= index < len(self.clients):
            self.clients[index]["notes"] = new_notes
            print(f"Updated notes for {self.clients[index]['name']}")
        else:
            print("Invalid client index.")

    def remove_client(self, index: int) -> None:
        if 0 <= index < len(self.clients):
            removed = self.clients.pop(index)
            print(f"Removed client: {removed['name']}")
        else:
            print("Invalid client index.")

    def add_task(self, index: int, task: str) -> None:
        if 0 <= index < len(self.clients):
            self.clients[index]["tasks"].append(task)
            print(f"Added task to {self.clients[index]['name']}: {task}")
        else:
            print("Invalid client index.")

    def list_tasks(self, index: int) -> None:
        if 0 <= index < len(self.clients):
            tasks = self.clients[index]["tasks"]
            if tasks:
                print(f"Tasks for {self.clients[index]['name']}:")
                for task in tasks:
                    print(f"- {task}")
            else:
                print(f"No tasks assigned to {self.clients[index]['name']}")
        else:
            print("Invalid client index.")


def display_menu() -> None:
    print("\nClient Management System")
    print("1. Add client")
    print("2. List clients")
    print("3. Update client notes")
    print("4. Remove client")
    print("5. Add task to client")
    print("6. List tasks for client")
    print("0. Exit")


def main() -> None:
    cms = ClientManagementSystem()
    while True:
        display_menu()
        choice = input("Select an option: ")
        if choice == "1":
            name = input("Enter client name: ")
            phone = input("Enter phone number: ")
            notes = input("Enter initial notes (optional): ")
            cms.add_client(name, phone, notes)
        elif choice == "2":
            cms.list_clients()
        elif choice == "3":
            index = int(input("Enter client number to update notes: ")) - 1
            new_notes = input("Enter new notes: ")
            cms.update_notes(index, new_notes)
        elif choice == "4":
            index = int(input("Enter client number to remove: ")) - 1
            cms.remove_client(index)
        elif choice == "5":
            index = int(input("Enter client number to add task: ")) - 1
            task = input("Enter task description: ")
            cms.add_task(index, task)
        elif choice == "6":
            index = int(input("Enter client number to list tasks: ")) - 1
            cms.list_tasks(index)
        elif choice == "0":
            print("Exiting... Goodbye!")
            break
        else:
            print("Invalid choice. Please choose a valid option.")


if __name__ == "__main__":
    main()
