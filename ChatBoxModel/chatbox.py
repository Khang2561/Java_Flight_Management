import socket
#connect to model
import random
import json
import pickle
import numpy as np

import nltk
from nltk.stem import WordNetLemmatizer

from tensorflow.keras.models import load_model
lemmatizer = WordNetLemmatizer()

intents = json.loads(open('intents.json').read())
words = pickle.load(open('words.pkl','rb'))
classes = pickle.load(open('classes.pkl','rb'))
model = load_model('chatbot_model.h5')
def clean_up_sentence(sentence):
  sentence_words = nltk.word_tokenize(sentence)
  sentence_words = [lemmatizer.lemmatize(word) for word in sentence_words]
  return sentence_words

def bag_of_words(sentence):
  sentence_words = clean_up_sentence(sentence)
  bag = [0] * len(words)
  for w in sentence_words:
    for i, word in enumerate(words):
      if word == w:
        bag[i] = 1
  return np.array(bag)

def predict_class(sentence):
  bow = bag_of_words(sentence)
  res = model.predict(np.array([bow]))[0]
  ERROR_THRESHOLD = 0.25
  results = [[i,r] for i,r in enumerate(res) if r > ERROR_THRESHOLD]

  results.sort(key=lambda x:x[1],reverse=True)
  return_list = []
  for r in results:
    return_list.append({'intent':classes[r[0]], 'probability':str(r[1])})
  return return_list

def get_response(intents_list, intents_json):
  tag = intents_list[0]['intent']
  list_of_intent = intents_json['intents']
  for i in list_of_intent:
    if i['tag']==tag:
      result = random.choice(i['responses'])
      break
  return result

kq = ""

def responJava(aws):
    #message = input(aws)
    ints = predict_class(aws)
    res = get_response(ints, intents)
    return str(res)



#import socket
HOST = 'localhost'
PORT = 4999

server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_socket.bind((HOST, PORT))
server_socket.listen()

print("Server connected!!!")

client_socket, address = server_socket.accept()
print(f"Connection from {address} has been established.")
while True:
    print("waiting message from client")
    # Receive message from the client
    client_message = client_socket.recv(1024).decode('utf-8')
    if not client_message:
        break
    print(f"Client: {client_message}")

    # Send the response back to the client
    #client_socket.sendall("Đã nghe\n".encode('utf-8'))

    if client_message.lower() == 'bye':
        break
    # Prompt for server message
    #server_message = str(input("Your message:"))
    
    # Send the server's response back to the client
    #client_socket.sendall(server_message)
    client_socket.sendall("{}\n{}".format(responJava(client_message), "").encode('utf-8'))
    print("send")
# Close the client socket and server socket
client_socket.close()
server_socket.close()
