FROM python:3.8

WORKDIR /usr/src/webapp

COPY flask-app .
RUN pip install --no-cache-dir -r flask-app/requirements.txt

ENV FLASK_PORT=${WEBAPP_PORT:-'8081'}
EXPOSE ${FLASK_PORT}

CMD [ "python", "flask-app/webapp.py" ]