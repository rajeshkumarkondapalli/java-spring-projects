#project

##generate folders
mkdir zappa_app
cd zappa_app
python -m venv venv
### for mac: source venv/bin/activate
### for windows: venv\Scripts\activate


## check dependencies
pip install flask
pip install zappa

flask --help
zappa --help


##test locally
flask run

## generate artifacts
zappa init

pip freeze > requirements.txt


##RUN
zappa deploy dev

zappa update dev

zappa udeploy dev
