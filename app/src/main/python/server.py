from flask import Flask, request, jsonify

app = Flask(__name__)

# Simulated user database (in-memory dictionary)
users = {}

@app.route('/register', methods=['POST'])
def register():
    """Register a new user with username and password"""
    data = request.get_json()
    username = data.get('username')
    password = data.get('password')

    if not username or not password:
        return jsonify({"error": "Username and password required"}), 400

    if username in users:
        return jsonify({"error": "User already exists"}), 400

    users[username] = password
    return jsonify({"message": "User registered successfully"}), 201


@app.route('/login', methods=['POST'])
def login():
    """Authenticate user with username and password"""
    data = request.get_json()
    username = data.get('username')
    password = data.get('password')

    if not username or not password:
        return jsonify({"error": "Username and password required"}), 400

    if username not in users or users[username] != password:
        return jsonify({"error": "Invalid username or password"}), 401

    return jsonify({"message": "Login successful"}), 200


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000, debug=True)
