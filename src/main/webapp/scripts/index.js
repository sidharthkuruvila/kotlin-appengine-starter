$(function () {
  // Initialize Firebase
  var config = {
    apiKey: "${firebase.api_key}",
    authDomain: "${appengine.project_name}.firebaseapp.com",
    databaseURL: "${appengine.project_name}.firebaseio.com",
    projectId: "${appengine.project_name}",
    storageBucket: "${appengine.project_name}.appspot.com",
    messagingSenderId: "${firebase.messaging_sender_id}"
  };

//Copied from https://github.com/GoogleCloudPlatform/python-docs-samples/blob/master/appengine/standard/firebase/firenotes/frontend/main.js

  var userIdToken = null;

// Firebase log-in
  function configureFirebaseLogin() {

    firebase.initializeApp(config);

    // [START onAuthStateChanged]
    firebase.auth().onAuthStateChanged(function (user) {
      if (user) {
        $('#logged-out').hide();
        var name = user.displayName;

        /* If the provider gives a display name, use the name for the
         personal welcome message. Otherwise, use the user's email. */
        var welcomeName = name ? name : user.email;

        user.getToken().then(function (idToken) {
          userIdToken = idToken;

          /* Now that the user is authenicated, fetch the notes. */
          //fetchNotes();

          $('#user').text(welcomeName);
          $('#logged-in').show();

        });

      } else {
        $('#logged-in').hide();
        $('#logged-out').show();

      }
      // [END onAuthStateChanged]

    });

  }

  function configureFirebaseLoginWidget() {
    var uiConfig = {
      'signInSuccessUrl': '/',
      'signInOptions': [
        // Leave the lines as is for the providers you want to offer your users.
        firebase.auth.GoogleAuthProvider.PROVIDER_ID
      ],
      // Terms of service url
      'tosUrl': '<your-tos-url>',
    };

    var ui = new firebaseui.auth.AuthUI(firebase.auth());
    ui.start('#firebaseui-auth-container', uiConfig);
  }

  var signOutBtn = $('#sign-out');
  signOutBtn.click(function (event) {
    event.preventDefault();

    firebase.auth().signOut().then(function () {
      console.log("Sign out successful");
    }, function (error) {
      console.log(error);
    });
  });

  configureFirebaseLogin();
  configureFirebaseLoginWidget();
})
