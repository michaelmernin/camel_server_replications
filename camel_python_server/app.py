from flask import Flask, request, jsonify
import csv
import json

app = Flask(__name__)

@app.route('/sync', methods=['POST'])
def welcome():
    y = request
    x = request.data
    if 'last_entry' in y.values:
        last_entry = y.values['last_entry']
    else:
        entry = str(request.data)[2:-1].strip("\\")
        last_entry = json.loads(entry)['last_entry']
    with open('numbers.csv', 'r', newline='') as f:
        reader = csv.reader(f)
        row1 = next(reader)
        f.close()

    record = int(row1[0])
    if int(last_entry) > record:
        with open('numbers.csv', 'w', newline='') as k:
            writer = csv.writer(k)
            writer.writerows(last_entry)

        status = 'changed'
    else:
        status = 'unchanged'

    return jsonify({'status': status, 'value_on_file': str(record)})

# @app.route('/upload', methods=['POST'])


if __name__ == '__main__':
    app.debug = True
    app.run()