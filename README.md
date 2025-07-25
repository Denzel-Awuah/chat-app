# Chat App

Client-Server chatting application built using Java.

## Overview

This project is a simple chat application that demonstrates basic client-server architecture using Java sockets. It allows multiple clients to connect to a server and exchange messages in real-time.

## Features

- Real-time messaging between clients
- Multi-client support via server threading
- Simple command-line interface for both client and server
- Easy setup and execution

## Technologies Used

- **Java** (100%)

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or above

### Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Denzel-Awuah/chat-app.git
   cd chat-app
   ```

2. **Compile the code:**
   ```bash
   javac Server.java
   javac Client.java
   ```

### Running the Server

Start the server first:

```bash
java Server
```

By default, the server will listen on port 12345. You can modify the port in the code if needed.

### Running the Client

Start one or more clients:

```bash
java Client
```

You will be prompted to enter the server's IP address and port.

## Usage

- Run the server.
- Launch clients and connect to the server.
- Each client can send messages that will be broadcast to all connected clients.
- Type messages and press Enter to send.

## Project Structure

```
chat-app/
├── Server.java
├── Client.java
├── README.md
```

## Contributing

Pull requests are welcome. For significant changes, please open an issue first to discuss what you would like to change.

## License

This project is licensed under the MIT License.

---

**Author:** [Denzel-Awuah](https://github.com/Denzel-Awuah)
