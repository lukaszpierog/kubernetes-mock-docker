# kubernetes-mock-docker
Dockerized k8s mock server from fabric8 kubernetes-client (https://github.com/fabric8io/kubernetes-client#mocking-kubernetes)

Use from docker hub: docker pull lukaszpierog/kubernetes-mock:1.0

Default port is 8088, can be changed by env PORT=1234

Mock server works in CRUD mode
Custom resources can be registered at startup by setting env, 
i.e. CUSTOM_KUBERNETES_RESOURCES='package.com/v1alpha1#ObjectConfig,package.com/v1alpha1#OtherConfig'
