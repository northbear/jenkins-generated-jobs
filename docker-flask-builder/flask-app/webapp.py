from os import getenv
from flask import Flask, escape, request

app = Flask(__name__)

@app.route('/')
def hello():
    name = request.args.get("name", "World")
    return f'Hello, {escape(name)}!'

@app.route('/status')
def status():
    status = {
        'status': 'OK',
        'numbers': [1, 2, 3, 4]
    }
    return status

def main():
    port = getenv('FLASK_PORT')
    assert port, 'Port number should be defined by envvar FLASK_PORT'

    app.run(port=port, debug=True)
    
if __name__ == '__main__':
    main()
